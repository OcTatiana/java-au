import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MarkdownEntityTest {
    public static final String TASK_TITLE = "Sqrt(x)";
    public static final String TASK_URL = "https://leetcode.com/problems/sqrt-x/";
    public static final String TASK_SOLUTION = "``` java\n" + "def mySqrt(self, x: int) -> int:\n" +
            "    res = 0\n" +
            "    while res**2 <= x:\n" +
            "        res = res + 1\n" +
            "    return res - 1\n```";

    public static final String FORMATTED_CODE = "## Sqrt(x)\n" + "\n" +
            "https://leetcode.com/problems/sqrt-x/\n" + "\n" +
            "``` java\n" +
            "def mySqrt(self, x: int) -> int:\n" +
            "    res = 0\n" +
            "    while res**2 <= x:\n" +
            "        res = res + 1\n" +
            "    return res - 1\n" +
            "```";

    public static final String NEW_SOLUTION = "69. Sqrt(x)\n" +
            "https://leetcode.com/problems/sqrt-x/\n" +
            "class Solution:\n" +
            "    def mySqrt(self, x: int) -> int:\n" +
            "        res = 0\n" +
            "        while res**2 <= x:\n" +
            "            res = res + 1\n" +
            "        return res - 1";

    @Test
    void testGetTitle() {
        assertEquals("+ [Sqrt(x)](#sqrt-x)", new MarkdownEntity(TASK_TITLE, TASK_URL, TASK_SOLUTION).getTitle());
    }

    @Test
    void testGetFormattedCode() {
        assertEquals(FORMATTED_CODE, new MarkdownEntity(TASK_TITLE, TASK_URL, TASK_SOLUTION).getFormattedCode());
    }

    @Test
    void testParseEntity() {
        MarkdownEntity res = MarkdownEntity.parseEntity(NEW_SOLUTION);
        assertEquals(new MarkdownEntity(TASK_TITLE, TASK_URL, TASK_SOLUTION), res);
    }
}