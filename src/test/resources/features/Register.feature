Feature: Register Account Functionality

  Background:
    Given the user opens the Tutorial Ninja application in a browser
    And the user navigates to the "Register Account" page

  @TC_RF_001
  Scenario Outline: Register an account using mandatory fields
    When the user enters valid mandatory registration details "<firstname>", "<lastname>", "<Mail>", "<Telephone>", "<Password>", "<PasswordConfirm>"
    And the user agrees to the Privacy Policy
    And the user clicks the "Continue" button
    Then the user should be taken to the "Account Success" page

    Examples:
      | firstname | lastname | Mail                             | Telephone | Password | PasswordConfirm |
      | Maverick  | Doe      | mave12rickdoe1242test1@gmail.com | 123456787 | Abclkj   | Abclkj          |

  @TC_RF_002
  Scenario: Register an account without entering any details
    When the user clicks the "Continue" button
    Then validation errors should be displayed

  @TC_RF_003 @TC_RF_004
  Scenario Outline: Register an account with Newsletter preference
    When the user enters valid mandatory registration details "<firstname>", "<lastname>", "<Mail>", "<Telephone>", "<Password>", "<PasswordConfirm>"
    And the user selects "<newsletter>" for the Newsletter option
    And the user agrees to the Privacy Policy
    And the user clicks the "Continue" button
    Then the user should be taken to the "Account Success" page

    Examples:
      | firstname | lastname | Mail                          | Telephone | Password | PasswordConfirm | newsletter |
      | Demo      | Doe1122  | de212mo3331242test1@gmail.com | 123456787 | Abclkj   | Abclkj          | Yes        |
      | Democc    | Doecc23  | de122mocc33124tst21@gmail.com | 123456787 | Abclkj   | Abclkj          | No         |

  @TC_RN_001
  Scenario: Navigate to Register Account page through My Account menu
    Given the user opens the Tutorial Ninja application in a browser
    When the user clicks on the "My Account" drop-down menu
    And the user clicks on the "Register" option
    Then the user should be taken to the "Register Account" page

  @TC_RN_002
  Scenario: Navigate to Register Account page through Login New Customer option
    Given the user opens the Tutorial Ninja application in a browser
    When the user clicks on the "My Account" drop-down menu
    And the user clicks on the "Login" option
    And the user clicks on the "Continue" button inside the "New Customer" box
    Then the user should be taken to the "Register Account" page

  @TC_RN_003
  Scenario: Navigate to Register Account page through Login Right Column Register option
    Given the user opens the Tutorial Ninja application in a browser
    When the user clicks on the "My Account" drop-down menu
    And the user clicks on the "Login" option
    And the user clicks on the "Register" option from the Right Column options
    Then the user should be taken to the "Register Account" page

  @TC_PC_001
  Scenario Outline: Register an account with different Password and Password Confirm values
    Given the user opens the Tutorial Ninja application in a browser
    When the user clicks on the "My Account" drop-down menu
    And the user clicks on the "Register" option
    And the user enters valid mandatory registration details "<firstname>", "<lastname>", "<Mail>", "<Telephone>", "<Password>", "<PasswordConfirm>"
    And the user agrees to the Privacy Policy
    And the user clicks the "Continue" button
    Then the password confirmation validation error should be displayed

    Examples:
      | firstname | lastname | Mail                         | Telephone | Password | PasswordConfirm |
      | Maverick  | Doe      | maveri11cktest1242@gmail.com | 123456787 | 12345    | abcde           |

  @TC_EV_001
  Scenario: Register an account using an existing email address
    When the user enters valid mandatory registration details "<firstname>", "<lastname>", "<Mail>", "<Telephone>", "<Password>", "<PasswordConfirm>"
    And the user agrees to the Privacy Policy
    And the user clicks the "Continue" button
    Then the Email  validation error should be displayed

    Examples:
      | firstname | lastname | Mail                 | Telephone | Password | PasswordConfirm |
      | Maverick  | Doe      | johndoe111@gmail.com | 123456787 | Abclkj   | Abclkj          |

  @TC_EV_002
  Scenario: Register an account using an invalid email address
    When the user enters valid mandatory registration details "<firstname>", "<lastname>", "<Telephone>", "<Password>", "<PasswordConfirm>"
    And user enter invalid email address "<Mail>"
    And the user agrees to the Privacy Policy
    And the user clicks the "Continue" button
    Then the Email correction error should be displayed

    Examples:
      | firstname | lastname | Mail              | Telephone | Password | PasswordConfirm |
      | Maverick  | Doe      | maverickdoe@gmail | 123456787 | Abclkj   | Abclkj          |

  @TC_PH_001
  Scenario: Verify all the fields in the Register Account page have the proper placeholders
    Then all the registration fields should have the proper placeholder

  @TC_PC_002
  Scenario: Verify whether the Password fields in the Register Account page are following Password Complexity Standards
    When the user enters valid mandatory registration details "<firstname>", "<lastname>","<Mail>", "<Telephone>"
    And user enter invalid password format "<Password>", "<PasswordConfirm>"
    And the user agrees to the Privacy Policy
    And the user clicks the "Continue" button
    Then the Password correction error should be displayed

    Examples:
      | firstname | lastname | Mail                           | Telephone | Password | PasswordConfirm |
      | Maverick  | Doe      | maverddick33doe12345@gmail.com | 123456787 | 123      | 123             |

  @TC_PC_003
  Scenario: Verify Registring an Account, by filling Password field and not filling Password Confirm field
    When the user enters valid mandatory registration details "<firstname>", "<lastname>", "<Mail>", "<Telephone>","<Password>"
    And user enter password field "<PasswordConfirm>"
    And the user agrees to the Privacy Policy
    And the user clicks the "Continue" button
    Then the Password correction error should be displayed

    Examples:
      | firstname | lastname | Mail                            | Telephone | Password | PasswordConfirm |
      | Maverick  | Doe      | maversickdo22aae12345@gmail.com | 123456787 | 1234567  |                 |

  @TC_CB_001
  Scenario: Verify whether the Privacy Policy checkbox option is not selected by default
    Then the Privacy Policy checkbox should not be selected by default

  @TC_CB_002
  Scenario: Verify Registering the Account without selecting the Privacy Policy checkbox option
    When the user enters valid mandatory registration details "<firstname>", "<lastname>", "<Mail>", "<Telephone>", "<Password>", "<PasswordConfirm>"
    And the user does not agrees to the Privacy Policy
    And the user clicks the "Continue" button
    Then the Privacy error message should be displayed

    Examples:
      | firstname | lastname | Mail                 | Telephone | Password | PasswordConfirm |
      | Maverick  | Doe      | most12ly11@gmail.com | 123456787 | Abclkj   | Abclkj          |

  @TC_UI_001
  Scenario: Verify the Breadcrumb, Page Heading, Page URL, Page Title of Register Account Page
    Then the Register Account page URL should be correct
    And the Register Account page title sholud be correct
    And the Register Account page heading should be correct
    And the Register Account Breadcrumb should be correct
