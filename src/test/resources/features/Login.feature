@Login
Feature: Login Check Test Cases

  Background:
    Given User at home page
    When  Login page opens
  @AllEmptyStates
  Scenario Outline: Check  "<username>" username "<password>" password for login
    And  Write "<username>" for username field
    And  Write "<password>" for password field
    And  Click login button
    Then Check "<error>" message about credentials not valid
    Examples:
      | username | password | error                                    |
      | empty    | empty    | Geçerli bir e-posta adresi girmelisiniz. |
      | abcdefg  | empty    | Girdiğiniz şifre eksik veya hatalı.      |
      | empty    | 123456   | Geçerli bir e-posta adresi girmelisiniz. |

  @UnsuccessfulLogin
  Scenario Outline: Check Correct "<username>" username & False "<password>" Password for login
    And  Write "<username>" for username field
    And  Write "<password>" for password field
    And  Click login button
    Then Check "<error>" message about credentials not valid
    Examples:
      | username     | error                               | password        |
      | correctEmail | Girdiğiniz şifre eksik veya hatalı. | abc1234         |
      | asdfg        | Girdiğiniz şifre eksik veya hatalı. | correctPassword |

  @SuccessfulLogin
  Scenario Outline: Correct "<username>" Username &  Correct "<password>" Password for login
    And  Write "<username>" for username field
    And  Write "<password>" for password field
    And  Click login button
    Then Check Successful login
    Examples:
      | username     | password        |
      | correctEmail | correctPassword |