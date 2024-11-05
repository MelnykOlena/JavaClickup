Feature: Test api


#  Scenario Outline: Adding two numbers
#    Given a is <value1>
#    And b is <value2>
#    When I add a and b
#    Then the total should be <result>
#  Examples:
#  |value1 | value2 |  result |
#  |  21   |  3     |   24    |
#  |  2   |  3     |   5    |
#  |  2   |  31     |   39    |
#


  Scenario: Check api for Lists
      When Sent request to get list and get list id

    @smoke
  Scenario:  get lists
    When Sent request to get all lists
    Then Check that status code is 200



    @list @lala
  Scenario:  get folders
    When Sent request to get folders
    Then Check that status code is 200

    @folders @smoke
  Scenario:  get folders wrong status
    When Sent request to get folders
    Then Check that status code is 300

    @wip
    Scenario Outline:  createFolderFromFile
    When Create folder form file <file>
    Then Check that status code is <status>
      Examples:
      |file                                    |   status|
      |  create_folders.json                    |   200    |
      |     create_invalid_folder.json         |   200    |


      @manual
      Scenario: Sent put reqest
        When Sent request to put folders
        Then Check that status code is 200

  Scenario: Get Space Tags
    Given valid authorization token
    When request to get space tags
    Then response with the list of space tags

  Scenario: Create Space Tag
    Given valid authorization token
    When request to create a space tag
    Then response with the created space tag