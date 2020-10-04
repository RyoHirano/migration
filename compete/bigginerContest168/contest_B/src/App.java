import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        LimitInput limit = LimitInput.getInstance();
        Input input = Input.getInstance();
        Scanner sc = new Scanner(System.in);
        String sResult = "";

        // Int変換することで速度向上
        limit.setLimit(Integer.parseInt(sc.next()));
        input.setInput((sc.next()));

        final String sInput = input.getInput();
        final int iLimit = limit.getLimit();
        if (iLimit < sInput.length()) {
            input.setSubStrInput(sInput.substring(0, iLimit));
            sResult = input.addLimitOverVal(input.getSubStrInput());
        } else {
            sResult = sInput;
        }

        System.out.print(sResult);

    }

    static class LimitInput {

        private int m_iLimit;

        private static LimitInput m_Me = null;

        private LimitInput() {
            m_iLimit = 0;

        }

        private int getLimit() {
            return m_iLimit;
        }

        private void setLimit(final int iLimitInput) {
            m_iLimit = iLimitInput;
        }

        public static LimitInput getInstance() {
            return m_Me = new LimitInput();
        }
    }

    static class Input {

        private static final String ADD_STR_VAL = "...";

        private String m_sInput;
        private String m_sSubStrInput;
        private static Input m_Me = null;

        Input() {
            m_sInput = "";
            m_sSubStrInput = "";
        }

        private void setInput(final String sInput) {
            m_sInput = sInput;
        }

        private String getInput() {
            return m_sInput;
        }

        private void setSubStrInput(final String sSubStrInput) {
            m_sSubStrInput = sSubStrInput;
        }

        private String getSubStrInput() {
            return m_sSubStrInput;
        }

        private String addLimitOverVal(final String sInput) {
            StringBuilder sb = new StringBuilder();
            sb.append(sInput);
            sb.append(ADD_STR_VAL);
            return sb.toString();
        }

        public static Input getInstance() {
            return m_Me = new Input();
        }

    }
}
