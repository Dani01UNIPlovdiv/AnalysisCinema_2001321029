Feature: Creating projection

  Scenario Outline: Creating projection
    Given Adding new projection screen is opened
    When Choose cinema from list: "<cinema>"
    And Choose movie from list: "<movie>"
    And Choose start time of projection: "<startTime>"
    And Choose hall: "<hall>"
    And Press button for new projection
    Then Displayed message: "<expectedMessage>"
    Examples:
      | cinema     |  movie    | startTime           | hall | expectedMessage               |
      | ArenaMax   |  Venom    | 21-06-2023 15:00:00 | STU  | Reservation successful! |
      | Arena      | Harry Potter | 20-06-2023 15:00:00 | 3D  | Non-existing cinema! |
      | Cinema City |  My Fault | 11-08-2023 15:00:00 | 5D  | Non-existing movie! |
      | EccoPlex | Extraction 2 | 17-08-2023 15:00:00 | 2D  | Hall is full! |
      | ArenaMax QHD | Evil Dead Rise | 12-01-2024 15:00:00 | 4K 3D  | Can't choose previous projection date! |
