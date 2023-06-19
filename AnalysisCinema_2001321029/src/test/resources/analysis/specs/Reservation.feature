Feature: Reservation of a seat

  Scenario Outline: Reservation of a seat
    Given Open the reservation screen
    When Input name: "<username>"
    And Choose cinema: "<cinema>"
    And Choose movie: "<movie>"
    And Choose start of projection: "<startTime>"
    And Compare reservation time "<timeOfReservation>"
    And Choose row: <row>
    And Choose seat: <num>
    And Press reservation button
    Then Input message: "<expectedMessage>"
    Examples:
      | username | cinema     | movie | startTime           | timeOfReservation   | row | num | expectedMessage                |
      | Danail   | Arena Max  | Venom | 15-05-2023 15:00:00 | 15-05-2023 13:00:00 | 5   | 8   | Reservation successful!        |
      | Vladimir | Arena    | Harry Potter | 15-05-2023 15:00:00 | 15-05-2023 13:00:00 | 5   | 8   | You haven't chosen the cinema! |
      | Danail   | EccoPlex | Extraction 2| 15-05-2023 15:00:00 | 15-05-2023 13:00:00 | 5   | 8   | You haven't chosen the movie!  |
      | Kristian | ArenaMax QHD | SpiderMan | 15-05-2023 15:00:00 | 15-05-2023 13:00:00 | 1   | 2   | The spot is taken!             |
      | Funki    | cinemaCity | SpiderMan | 15-05-2023 15:00:00 | 15-05-2023 14:30:00 | 5   | 8   | Reservation has to be at least 60 minutes before the projection! |

