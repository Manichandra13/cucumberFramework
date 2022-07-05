@FAS @Login @RegressionTest @Set2
Feature: Validating Login Feature
  Verify that the Login feature is working across the product

  #Login validation in GCM page
  @SmokeTest @RegressionTest
  Scenario Outline: Login validation in GCM page
    Given Login as a authenticated user from GCM page with "<region>"

    Examples: 
      | region |
      | Australia   |

  #Login validation from landing page
  @RegressionTest @SmokeTest
  Scenario Outline: Login validation from landing page with Valid credentials
    Then Login to the application with valid username and password with "<uName>" and "<passwd>"

    Examples: 
      | uName      | passwd      |
      | 9444422016 | travelisfun |

  #@RegressionTest
  Scenario Outline: Login validation from landing page with inValid credentials
    Then Login to the application with valid username and invalid password with "<uName>" and "<passwd>"

    Examples: 
      | uName      | passwd         |
      | 9444422016 | JustAJunkValue |

  @RegressionTest
  Scenario Outline: Login validation from landing page with inValid credentials
    Then Login to the application with invalid username and valid password with "<uName>" and "<passwd>"

    Examples: 
      | uName       | passwd      |
      | 9444422016 | travelisfun |

  #@RegressionTest
  Scenario Outline: Login validation from landing page with inValid credentials
    Then Login to the application with invalid username and invalid password with "<uName>" and "<passwd>"

    Examples: 
      | uName       | passwd         |
      | 9444422016 | JustAJunkValue |

  #Login Validation from Landing page via signup modal for existing user
  @RegressionTest
  Scenario: Login Validation from the signup modal with registered user
    Then Login from signup modal by entering registered user data and then logging in

  #Login Validation from Landing page via already have an account
  @RegressionTest
  Scenario: Login Validation from the signup modal by choosing Already have an account
    Then Login from signup modal via Already have an account CTA with valid credentials

  @RegressionTest
  Scenario: Login Validation from the signup modal by choosing Already have an account
    Then Login from signup modal via Already have an account CTA with invalid username

  @RegressionTest
  Scenario: Login Validation from the signup modal by choosing Already have an account
    Then Login from signup modal via Already have an account CTA with invalid password

  @RegressionTest
  Scenario: Login Validation from the signup modal by choosing Already have an account
    Then Login from signup modal via Already have an account CTA with invalid credentials

  #Login validation from PDG flow using GCM
  #Login validation from GCM via already got an account
  @RegressionTest
  Scenario Outline: Login validation from PDG Flow using GCM via already got an account
    Given Login from PDG Flow using GCM via already got an account with "<region>"

    Examples: 
      | region |
      | Australia   |

  #Login validation from GCM via signup
  @RegressionTest
  Scenario Outline: Login validation from PDG Flow using GCM via Signup
    Given Login from PDG Flow using GCM via Signup as existing user with "<region>"

    Examples: 
      | region |
      | Australia   |

  #Login validation from GCM via signup to get free quotes link
  @RegressionTest
  Scenario Outline: Login validation from PDG Flow using Calculate trip cost via GCM Signup
    Given Login from PDG Flow using GCM via GCM Signup with "<region>"

    Examples: 
      | region |
      | Australia   |

  #Login validation from PDG flow using Calculate trip cost CTA
  #Login validation from CTC via already got an account
  @RegressionTest
  Scenario Outline: Login validation from PDG Flow using Calculate trip cost via already got an account
    Given Login from PDG Flow using Calculate trip cost via already got an account with "<region>"

    Examples: 
      | region |
      | Australia   |

  #Login validation from CTC via signup
  @RegressionTest
  Scenario Outline: Login validation from PDG Flow using Calculate trip cost via Signup
    Given Login from PDG Flow using Calculate trip cost via Signup as existing user with "<region>"

    Examples: 
      | region |
      | Australia   |

  #Login validation from CTC via signup to get free quotes link
  @RegressionTest
  Scenario Outline: Login validation from PDG Flow using Calculate trip cost via GCM Signup
    Given Login from PDG Flow using Calculate trip cost via GCM Signup with "<region>"

    Examples: 
      | region |
      | Australia   |

  #Header Login validation from Itinerary page
  #Header Login validation from Itinerary page via already got an account
  @RegressionTest
  Scenario Outline: Login validation from Itinerary page header login via already got an account
    Given Login from Itinerary page using Header login via already got an account with "<region>"

    Examples: 
      | region |
      | Australia   |

  #Header Login validation from Itinerary page via regular login
  @RegressionTest
  Scenario Outline: Login validation from Itinerary page header login via regular login
    Given Regular login through headers login from Itinerary page with "<region>"

    Examples: 
      | region |
      | Australia   |

  #Header Login validation from Itinerary page via signup to get free quotes
  @RegressionTest
  Scenario Outline: Login validation from Itinerary page using header login signup
    Given Login from Itinerary page using Header login via signup with "<region>"

    Examples: 
      | region |
      | Australia   |

  #Header Login validation from packages pages
  #Header Login validation from packages page via already got an account
  @RegressionTest
  Scenario Outline: Login validation from packages page header login
    Given Login from package page using Header login via already got an account with "<region>"

    Examples: 
      | region |
      | Australia   |

  #Header Login validation from packages page via regular login
  @RegressionTest
  Scenario Outline: Login validation from packages page header login
    Given Regular login through headers login from packages page with "<region>"

    Examples: 
      | region |
      | Australia   |

  #Header Login validation from packages page via signup to get free quotes
  @RegressionTest
  Scenario Outline: Login validation from packages page using header login signup
    Given Login from package page using Header login via signup with "<region>"

    Examples: 
      | region |
      | Australia   |

  #Login Validation from GCM packages page
  #Login validation from Packages pages via signup to get free quotes link
  @RegressionTest
  Scenario Outline: Login validation from packages page via GCM Signup
    Given Login from packages page via GCM Signup with "<region>"

    Examples: 
      | region |
      | Australia   |

  #Login validation from Packages pages via already got an account
  @RegressionTest
  Scenario Outline: Login using customize option from any one of the packages in PYT
    Given Login from packages page using custiomize option via already got an account with "<region>"

    Examples: 
      | region |
      | Australia   |

  #Login validation from Packages pages via signup
  @RegressionTest
  Scenario Outline: Login validation from packages page via Signup
    Given Login from packages page via Signup as existing user with "<region>"

    Examples: 
      | region |
      | Australia   |

  #Login validation from Paid campaign pages
  #Login validation from Paid campaign pages via already got an account
  @RegressionTest
  Scenario Outline: Login using customize option from any one of the packages in Australia paid campaign page in PYT
    Given Login from paid campaign page using custiomize option via already got an account with "<region>"

    Examples: 
      | region |
      | Australia   |

  #Login validation from Paid campaign pages via signup
  @RegressionTest
  Scenario Outline: Login validation from paid campaign page  via Signup
    Given Login from paid campaign page via Signup as existing user with "<region>"

    Examples: 
      | region |
      | Australia   |

  #Login validation from Paid campaign pages via signup to get free quotes link
  @RegressionTest
  Scenario Outline: Login validation from paid campaign page via GCM Signup
    Given Login from paid campaign page via GCM Signup with "<region>"

    Examples: 
      | region |
      | Australia   |
