from pathlib import Path
from collections import defaultdict
from urllib.parse import quote
import re

# =========================
# 기본 설정
# =========================
ROOT = Path(__file__).resolve().parent.parent
README = ROOT / "README.md"

START = "<!-- SOLVED_START -->"
END = "<!-- SOLVED_END -->"

REPO_URL = "https://github.com/won3956/Algorithm"
BRANCH = "main"

# 집계할 소스코드 확장자
EXTENSIONS = {
    ".java", ".py", ".c", ".cpp", ".cc",
    ".cxx", ".js", ".ts", ".kt", ".go", ".rs"
}

PLATFORMS = ["Baekjoon", "SWEA", "프로그래머스"]

# 플랫폼 -> {(문제번호): 문제정보}
problems = {platform: {} for platform in PLATFORMS}

# 강의·실습: 중복되지 않는 소스코드 경로
practices = defaultdict(list)


def github_url(path):
    """GitHub 파일 또는 폴더 링크 생성"""
    relative = path.relative_to(ROOT).as_posix()
    return f"{REPO_URL}/blob/{BRANCH}/{quote(relative, safe='/')}"


def folder_url(path):
    relative = path.relative_to(ROOT).as_posix()
    return f"{REPO_URL}/tree/{BRANCH}/{quote(relative, safe='/')}"


def clean_text(value):
    """마크다운 테이블에서 깨지는 문자 처리"""
    return value.replace("|", r"\|").replace("\n", " ")


def parse_folder(folder):
    """'1859. 백만 장자 프로젝트' -> (1859, 문제명)"""
    match = re.match(r"^(\d+)\.\s*(.+)$", folder)

    if not match:
        return None

    number = int(match.group(1))
    title = " ".join(match.group(2).split())
    return number, title


def add_problem(platform, number, title, category, path):
    """문제번호 기준 중복 제거"""
    if number not in problems[platform]:
        problems[platform][number] = {
            "title": title,
            "category": category,
            "path": path
        }


def add_practice(category, file):
    practices[category].append(file)


# =========================
# 1. 코드 파일 탐색
# =========================
for file in sorted(ROOT.rglob("*")):
    if not file.is_file():
        continue

    if file.suffix.lower() not in EXTENSIONS:
        continue

    relative = file.relative_to(ROOT)
    parts = relative.parts

    # Git 관련 및 자동화 코드 제외
    if any(p in {".git", ".github", "scripts"} for p in parts):
        continue

    top = parts[0]

    # ---------------------
    # Baekjoon
    # ---------------------
    if top == "Baekjoon":
        # Main1003.java, Main9095_2.java
        match = re.match(r"^Main(\d+)(?:_.*)?$", file.stem)

        if match:
            number = int(match.group(1))
            add_problem(
                "Baekjoon",
                number,
                f"문제 {number}",
                "Baekjoon",
                file
            )
        else:
            add_practice("Baekjoon 기타 실습", file)

    # ---------------------
    # SWEA
    # ---------------------
    elif top == "SWEA":
        matched = False

        # SWEA/D4/1249. 보급로/...
        if len(parts) >= 4:
            category = parts[1]
            parsed = parse_folder(parts[2])

            if parsed and (
                re.fullmatch(r"D\d+", category)
                or category in {"Unrated", "A형"}
            ):
                number, title = parsed
                add_problem(
                    "SWEA",
                    number,
                    title,
                    category,
                    ROOT.joinpath(*parts[:3])
                )
                matched = True

        if not matched:
            # 강의, B형, Solution.java 등
            category = parts[1] if len(parts) > 2 else "기타"
            add_practice(f"SWEA/{category}", file)

    # ---------------------
    # 프로그래머스
    # ---------------------
    elif top == "프로그래머스":
        matched = False

        # 프로그래머스/1/468371. 문제명/...
        if len(parts) >= 4:
            parsed = parse_folder(parts[2])

            if parsed:
                number, title = parsed
                add_problem(
                    "프로그래머스",
                    number,
                    title,
                    f"Level {parts[1]}",
                    ROOT.joinpath(*parts[:3])
                )
                matched = True

        if not matched:
            add_practice("프로그래머스 기타 실습", file)

    # ---------------------
    # SSAFY 및 기타
    # ---------------------
    else:
        add_practice(f"{top} 실습", file)


# =========================
# 2. 통계 계산
# =========================
total_problems = sum(
    len(items) for items in problems.values()
)

total_practices = sum(
    len(items) for items in practices.values()
)

lines = [
    "## 전체 학습 현황",
    "",
    f"**해결 문제: {total_problems}개**  ",
    f"**강의·실습 코드: {total_practices}개**",
    "",
    "### 플랫폼별 문제 풀이",
    "",
    "| 플랫폼 | 문제 수 |",
    "|---|---:|",
]

display_names = {
    "Baekjoon": "백준",
    "SWEA": "SWEA",
    "프로그래머스": "프로그래머스"
}

for platform in PLATFORMS:
    count = len(problems[platform])
    lines.append(f"| {display_names[platform]} | {count} |")

lines.extend([
    f"| **합계** | **{total_problems}** |",
    "",
    "### SWEA 난이도별 현황",
    "",
    "| 분류 | 문제 수 |",
    "|---|---:|",
])

swea_counts = defaultdict(int)

for info in problems["SWEA"].values():
    swea_counts[info["category"]] += 1

for category in sorted(swea_counts):
    lines.append(
        f"| {clean_text(category)} | {swea_counts[category]} |"
    )



# =========================
# 3. 문제 목록 생성
# =========================
lines.extend([
    "",
    "## 해결한 문제 목록",
    ""
])

for platform in PLATFORMS:
    items = problems[platform]

    lines.append(
        f"### {display_names[platform]} ({len(items)}문제)"
    )
    lines.append("")

    if not items:
        lines.append("등록된 문제가 없습니다.")
        lines.append("")
        continue

    # SWEA와 프로그래머스만 난이도별 분류
    if platform in {"SWEA", "프로그래머스"}:
        grouped = defaultdict(list)

        for number, info in items.items():
            grouped[info["category"]].append((number, info))

        # 난이도 순서 지정
        if platform == "SWEA":
            order = [
                "D1", "D2", "D3", "D4", "D5",
                "D6", "D7", "D8",
                "Unrated", "A형"
            ]
        else:
            order = [
                "Level 0", "Level 1", "Level 2",
                "Level 3", "Level 4", "Level 5"
            ]

        categories = sorted(
            grouped.keys(),
            key=lambda c: (
                order.index(c) if c in order else len(order),
                c
            )
        )

        for category in categories:
            category_items = sorted(grouped[category])

            lines.append(
                f"#### {category} ({len(category_items)}문제)"
            )
            lines.append("")
            lines.append("| 번호 | 문제명 | 풀이 |")
            lines.append("|---|---|---|")

            for number, info in category_items:
                title = clean_text(info["title"])
                path = info["path"]

                if path.is_dir():
                    url = folder_url(path)
                else:
                    url = github_url(path)

                lines.append(
                    f"| {number} | {title} | [보기]({url}) |"
                )

            lines.append("")

    # 백준은 기존처럼 전체 목록 유지
    else:
        lines.append("| 번호 | 문제명 | 풀이 |")
        lines.append("|---|---|---|")

        for number, info in sorted(items.items()):
            title = clean_text(info["title"])
            path = info["path"]

            if path.is_dir():
                url = folder_url(path)
            else:
                url = github_url(path)

            lines.append(
                f"| {number} | {title} | [보기]({url}) |"
            )

        lines.append("")



# =========================
# 4. 강의 및 실습 목록
# =========================
lines.extend([
    "## 강의 및 실습 기록",
    "",
    f"**총 {total_practices}개 소스코드 파일**",
    ""
])

for category, files in sorted(practices.items()):
    lines.append(f"### {clean_text(category)} ({len(files)}개)")
    lines.append("")

    for file in files:
        name = clean_text(file.relative_to(ROOT).as_posix())
        lines.append(f"- [{name}]({github_url(file)})")

    lines.append("")


# =========================
# 5. README 수정
# =========================
generated = "\n".join(lines).rstrip()

text = README.read_text(encoding="utf-8")

if text.count(START) != 1 or text.count(END) != 1:
    raise ValueError(
        "README에 SOLVED_START / SOLVED_END 마커가 "
        "각각 하나씩 필요합니다."
    )

pattern = re.compile(
    re.escape(START) + r".*?" + re.escape(END),
    re.DOTALL
)

replacement = (
    f"{START}\n\n{generated}\n\n{END}"
)

updated = pattern.sub(
    lambda _: replacement,
    text,
    count=1
)

if updated != text:
    README.write_text(updated, encoding="utf-8")
    print("README 업데이트 완료")
else:
    print("README 변경 사항 없음")

print(f"문제 풀이: {total_problems}개")
print(f"강의·실습: {total_practices}개")
