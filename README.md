# Spring Boot with GraphQL Query Example

## User info
- `/rest/users` is the REST resource which can fetch user information
- DataFetchers are Interfaces for RuntimeWiring of GraphQL with JpaRepository / back end services

## Sample GraphQL Scalar Queries
- Accessible under `http://localhost:8091/rest/users`
- Usage for `allUsers`
`{
   allUsers {
     id
     firstName
     lastName
     dob
   }
 }`
- Usage for `User`
`{
   book(id: "123") {
     id
     firstName
     lstName
   }`
- Combination of both `allUsers` and `User`
`{
   allUsers {
     id
     firstName
   }
   user(id: "124") {
     id
     firstName
     lastName
   }
 }`