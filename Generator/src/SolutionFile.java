import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class SolutionFile {
    private List<ItemEntity> data;
    private String headTitle;

    public SolutionFile(List<ItemEntity> lst, String title) {
        this.data = lst;
        this.headTitle = title;
    }

    private static boolean checkMarkdownFile(ArrayList<String> title, ArrayList<String> code) {
        if (title.size() - 1 != code.size()) {
            System.out.println("ERROR_Size: Incorrect md file!\n");
            return false;
        }

        int n = code.size();

        for (int i = 0; i < n; i++) {
            String name1 = title.get(i+1).split("]")[0].substring(3);
            String name2 = code.get(i).split("\n")[0].substring(3);

            if (!name1.equals(name2)) {
                System.out.println("ERROR_Title: Incorrect md file!\n");
                return false;
            }
        }
        return true;
    }

    private static List<ItemEntity> parseMarkdownFile(String str) {
        String[] parts = str.split("\n<!---Comment-->");
        ArrayList<String> title = new ArrayList<String>(Arrays.asList(parts[0].split("\\R+")));
        ArrayList<String> linesOfCode = new ArrayList<String>(Arrays.asList(parts[1].split("[\\r\\n]+")));
        linesOfCode.removeAll(Arrays.asList("", null, "\n"));

        ArrayList<String> code = new ArrayList<String>();
        String tmp = "";
        for (String line : linesOfCode) {
            if (line.equals("```")) {
                tmp += line;
                code.add(tmp);
                tmp = "";
            } else {
                tmp += line;
                tmp += "\n";
            }
        }

        if (!checkMarkdownFile(title, code))
            return null;

        //парсинг
        ArrayList<ItemEntity> lst = new ArrayList<>();
        String taskTitle;
        String taskUrl;
        String taskSolution;
        String[] parse_lst;
        for (String problem : code) {
            parse_lst = problem.split("\n");
            taskTitle = parse_lst[0].substring(3);
            taskUrl = parse_lst[1];
            taskSolution = "";
            for (int i = 2; i < parse_lst.length; i++) {
                taskSolution += parse_lst[i];
                taskSolution += "\n";
            }
            ItemEntity task = new MarkdownEntity(taskTitle, taskUrl, taskSolution.substring(0, taskSolution.length() - 1));
            lst.add(task);
        }

        return lst;
    }

    public static SolutionFile parseFile(String s, FileType t, String filename) {
        List<ItemEntity> lst = new ArrayList<>();
        String title = "";
        if (t == FileType.MARKDOWN) {
            if (s.length() != 0) {
                lst = parseMarkdownFile(s);
            }
            title = "# " + filename.substring(0, 1).toUpperCase() + filename.substring(1) + "\n";
        } else if (t == FileType.HTML) {
            //проверка HTML
        } else if (t == FileType.LATEX) {
            //проверка LaTex
        } else {
            //error
        }
        if (lst != null)
            return new SolutionFile(lst, title);
        else
            return null;
    }

    public void add(MarkdownEntity other) {
        data.add(other);
    }

    @Override
    public String toString() {
        String res = headTitle + "\n";
        for (ItemEntity problem : data) {
            res += problem.getTitle();
            res += "\n";
        }

        res += "\n<!---Comment-->\n\n";

        for (ItemEntity problem : data) {
            res += problem.getFormattedCode();
            res += "\n\n";
        }

        return res;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SolutionFile that = (SolutionFile) o;
        return Objects.equals(data, that.data) && Objects.equals(headTitle, that.headTitle);
    }
}
