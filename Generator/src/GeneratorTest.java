import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GeneratorTest {
    public static final String RESULT = "# Math\n" +
            "\n" +
            "+ [Sqrt(x)](#sqrt-x)\n" +
            "\n" +
            "<!---Comment-->\n\n" +
            "## Sqrt(x)\n\n" +
            "https://leetcode.com/problems/sqrt-x/\n\n" +
            "``` java\n" +
            "def mySqrt(self, x: int) -> int:\n" +
            "    res = 0\n" +
            "    while res**2 <= x:\n" +
            "        res = res + 1\n" +
            "    return res - 1\n" +
            "```\n\n";

    public static final String NEW_SOLUTION = "69. Sqrt(x)\n" +
            "https://leetcode.com/problems/sqrt-x/\n" +
            "class Solution:\n" +
            "    def mySqrt(self, x: int) -> int:\n" +
            "        res = 0\n" +
            "        while res**2 <= x:\n" +
            "            res = res + 1\n" +
            "        return res - 1";

    public static final String TWO_SOLUTION_MD = "# Math\n" +
            "\n" +
            "+ [Sqrt(x)](#sqrt-x)\n" +
            "+ [Sqrt(x)](#sqrt-x)\n" +
            "\n" +
            "<!---Comment-->\n\n" +
            "## Sqrt(x)\n\n" +
            "https://leetcode.com/problems/sqrt-x/\n\n" +
            "``` java\n" +
            "def mySqrt(self, x: int) -> int:\n" +
            "    res = 0\n" +
            "    while res**2 <= x:\n" +
            "        res = res + 1\n" +
            "    return res - 1\n" +
            "```\n\n" +
            "## Sqrt(x)\n\n" +
            "https://leetcode.com/problems/sqrt-x/\n\n" +
            "``` java\n" +
            "def mySqrt(self, x: int) -> int:\n" +
            "    res = 0\n" +
            "    while res**2 <= x:\n" +
            "        res = res + 1\n" +
            "    return res - 1\n" +
            "```\n\n";

    public static final String FILE_PATH = "C:\\Users\\admin\\IdeaProjects\\21.10.02\\src\\math.md";

    @Test
    void testGetNewContentWithEmptyMD() {
        assertEquals(RESULT, Generator.getNewContent(NEW_SOLUTION, "", FILE_PATH));
    }

    @Test
    void testGetNewContentWithNonEmptyMD() {
        String oldFileContent = Generator.getNewContent(NEW_SOLUTION, "", FILE_PATH);
        //assertEquals(TWO_SOLUTION_MD, Generator.getNewContent(NEW_SOLUTION, oldFileContent, FILE_PATH));
        oldFileContent = Generator.getNewContent(NEW_SOLUTION, oldFileContent, FILE_PATH);
        assertEquals(TWO_SOLUTION_MD, oldFileContent);
    }


}