# hotel-reservation-management

Here's a quick video presentation of the project I've been refining overtime. The main branch contains the original version developed in the given time, while this showcases the near-final improvements. For a closer look at the enhancements and overtime work, please check out the [second branch](https://github.com/Candea-Marian/hotel-reservation-management/tree/overtime).

https://github.com/Candea-Marian/hotel-reservation-management/assets/56280373/99b0c6f7-c8ca-43ac-98b4-fe6f69a9b8c8

## Mandatory tasks:
- [x] The user specifies a radius in kilometers to find all the nearby hotels
- [x] The application lists and displays all hotels found (partial implementation)
- [x] The user can select a specific hotel and see all available rooms alongside their prices
- [x] After this, the user can book one, or more of the available rooms
- [x] The application allows the user to cancel their reservation or change the booked room at least
two hours before the check-in (partial)
- [ ] User can leave a feedback (services, cleanliness, etc)

Notes:
 - All the parts for the radius calculation are made, but I didn't have time to implement them in the service (check out DistanceCalculator and CoordinateConverter in the utils package).
 - The user can cancel the reservations by deleting them, but the edit feature isnt done yet.
 - Implemented database connection with MySQL and all the CRUD operations for Hotels, Rooms, and Reservations.
 - Implemented Spring Security Authentication to sign in against the database (IMPORTANT: if you run the application, use "user" as the username and "password" as the password).
 - Implemented a MapBox map to show the locations of the nearby hotels
