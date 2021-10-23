import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionFileTest {
    public static final String NON_EMPTY_FILE_CONTENT = "# Math\n" +
            "\n" +
            "+ [Sqrt(x)](#sqrt-x)\n" +
            "\n" +
            "<!---Comment-->\n" +
            "## Sqrt(x)\n" +
            "https://leetcode.com/problems/sqrt-x/\n" +
            "``` java\n" +
            "    def mySqrt(self, x: int) -> int:\n" +
            "        res = 0\n" +
            "        while res**2 <= x:\n" +
            "            res = res + 1\n" +
            "        return res - 1\n" +
            "```\n";

    public static final String TASK_TITLE = "Sqrt(x)";
    public static final String TASK_URL = "https://leetcode.com/problems/sqrt-x/";
    public static final String TASK_SOLUTION = "``` java\n" +
            "    def mySqrt(self, x: int) -> int:\n" +
            "        res = 0\n" +
            "        while res**2 <= x:\n" +
            "            res = res + 1\n" +
            "        return res - 1\n" +
            "```";

    @org.junit.jupiter.api.Test
    void testNotEmptyMarkdownFile() {
        SolutionFile result = SolutionFile.parseFile(NON_EMPTY_FILE_CONTENT, FileType.MARKDOWN, "math");
        List<ItemEntity> lst = List.of(new MarkdownEntity(TASK_TITLE, TASK_URL, TASK_SOLUTION));
        assertEquals(new SolutionFile(lst, "# Math\n"), result);
    }

    @org.junit.jupiter.api.Test
    void testEmptyMarkdownFile() {
        SolutionFile result = SolutionFile.parseFile("", FileType.MARKDOWN, "math");
        List<ItemEntity> lst = List.of();
        assertEquals(new SolutionFile(lst, "# Math\n"), result);
    }
}
