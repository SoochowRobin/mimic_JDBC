import java.util.ResourceBundle;

/**
 * Java programmer will not need to care about which database
 * they just need to care about interface
 */

public class JavaProgrammer {

    public static void main(String[] args) {

//         Java programmer just need to care about interface
//        JDBC jdbc = new MySQL();
//        JDBC jdbc = new Oracle();
//        jdbc.getConnection();

        /*
        Another method is to use property file to craete obeject
         */
        /**
         * We just need to modify className in property file to change database
         */
        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
        String className = bundle.getString("className");
        try {
            Class c = Class.forName(className);
            JDBC jdbc = (JDBC)c.newInstance();
            jdbc.getConnection();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
