// package JDBC;
/*
-   LearnJDBC " Learn Java Database Connectivity "
-   Developed by MayankDevil
-   https://github.com/MayankDevil/LearnJDBC
-   ./connection.java
*/ 
class ConnectionEstablished
{
    /*
    -   JDBC (Java Database Connectivity) is a Java-based API (Application Programming Interface) that allows Java applications to interact with relational databases.
    -   It provides a standard interface for connecting to and executing SQL queries against databases. 
    
    1.  Import the Necessary Packages :
        
        To use the JDBC API in your Java program, you simply import the `java.sql` package.

        [ syntax ]

            java.sql.Connection

            java.sql.DriverManager

    2.  Load the Database Driver :

        Database drivers help Java understand and talk to databases, which speak a different language called SQL.

        [ syntax ]

            Class.forName("com.mysql.cj.jdbc.Driver");

    3.  Establish a Database Connection :

        This code sets up a connection to a MySQL database with a specific URL, username, and password.

        [ syntax ]

            DriverManager.getConnection( url, username, password );

    4.  Execute SQL Queries :

        Executing SQL queries means telling the database to do something, like getting data or making changes, by sending it a command in SQL language.

    5.  Close the Connection :

        Always close the database connection and related resources like statements and result sets when you're done to save resources and prevent memory issues using the close() method.

        [ syntax ]

            connection_reference.closed();

    */ 
    public static void main(String[] args)
    {
        try
        {
            /*
                This line of code tells Java to find and load the MySQL database driver.
            */
            try
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
            }
            catch(java.lang.ClassNotFoundException error)
            {
                System.out.println("the driver class specified in Class.forName() or the JDBC URL is not found.");
            }
            /*
                [ getConnection() ] connection establish and return Connection & argument { url | username | password }
            */
            String url = "jdbc:mysql://localhost:3306/test";
            String username = "root";
            String password = "";
            
            java.sql.Connection connect = java.sql.DriverManager.getConnection(url,username,password);

            // [ isClosed() ] function return true if connection is closed else false

            if (!(connect.isClosed()))
            {
                System.out.println("Connection Established!");
            }
            connect.close();    // closed connection

            if (connect.isClosed())
            {
                System.out.println("Connection Closed!");
            }
        }
        catch(java.sql.SQLException error)
        {
            System.out.print(error.getMessage());
        }
    }
/* java -cp "D:\44\javaPrograms\jd\JDBC;C:\mysql-connector-j-8.2.0.jar" ConnectionEstablished */
}
// the end

/*
    ClassNotFoundException:
        Occurs when the driver class specified in Class.forName() or the JDBC URL is not found.
        Example: Class.forName("com.mysql.cj.jdbc.Driver") may throw ClassNotFoundException if the MySQL driver is not in the classpath.

    SQLException:
        A broad exception class that covers various SQL-related exceptions.
        Common reasons include incorrect SQL syntax, database server not available, authentication issues, etc.

    SQLSyntaxErrorException:
        Occurs when the SQL query has a syntax error.
        Example: A SQL query like "SELEC * FROM table" (misspelled "SELECT") will result in this exception.

    SQLDataException:
        Raised when there is a data-related issue, such as trying to insert a value into a database column of the wrong data type.

    SQLIntegrityConstraintViolationException:
        Happens when you violate a constraint, like trying to insert a duplicate primary key into a table.

    SQLTimeoutException:
        Occurs when a database operation takes longer than the specified timeout period.

    SQLNonTransientConnectionException:
        Indicates a problem with the database connection itself, such as network issues or the database server being unavailable.

    NullPointerException:
        May occur if you attempt to use a ResultSet, Statement, or Connection object that is not properly initialized.

    OutOfMemoryError:
        This is a severe error, not an exception. It can happen if you don't close resources correctly, leading to memory leaks.
*/