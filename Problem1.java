class Problem1 extends ConsoleProgram {

  /**
  * Description
  * @author: T. Martins
  */
  
  String firstName;
  String lastName;
  String studentNumber;
  String username;

  public void run() {
    
    System.out.println("***** Student Account Registration *****");
    
    firstName = readLine("Enter your first name: ");
    lastName = readLine("Enter your last name: ");
    studentNumber = readLine("Enter your student number: ");
    username = readLine("Enter a new username: ");

    try {
      createPassword(firstName, lastName, studentNumber);
    } catch (IndexOutOfBoundsException error) {
      System.out.println("Exception in thread 'main' java.lang.IllegalArgumentException: Incorrect parameters(s)");
    }

    System.out.println("");

    System.out.println("Valid username: " + validateUsername(username));

    try {
      System.out.println("Your password is: " + createPassword(firstName, lastName, studentNumber));
    } catch (IndexOutOfBoundsException error) {
      // empty to allow it to run
    }

  }

  /**
   * Determines if an inputted username consists of only letters and digits, has at least one digit, and is greater than 7 characters long.
   * @param user the username to be tested
   * @return true if the username meets the condtions; false otherwise.
   * 
   * @author T. Martins
   */
  public boolean validateUsername(String user) {

    boolean isDigit = false;

    if(user.length() <= 7){
      return false;
    }

    for(int i = 0; i < user.length(); i++){
      
      if (Character.isDigit(user.charAt(i)) == true){
        isDigit = true;
      } else if (Character.isLetterOrDigit(user.charAt(i)) == false){
        return false;
      } 

    }

    return isDigit;

  }

  /**
   * Creates a password using inputted first name, last name, and student number variables.
   * @param firstName your first name; initial is used for the password
   * @param lastName your last name; first 4 lowercase letters are used for password
   * @param studentNumber a 9 digit student number; middle 3 numbers are used 
   * @return 4 lowercase letters of last name + uppercase initial of first name + middle 3 numbers of student number.
   * 
   * @author T. Martins
   */
  public String createPassword(String firstName, String lastName, String studentNumber){
    
    String returnPassword = "";

    for(int i = 0; i < 4; i++){
      returnPassword += Character.toLowerCase(lastName.charAt(i));
    }

    returnPassword += Character.toUpperCase(firstName.charAt(0));

    for(int i = studentNumber.length()/2 - 1; i < studentNumber.length()/2 + 2; i++){

      returnPassword += studentNumber.charAt(i);
      
    }
    
    

    return returnPassword;

  }

}