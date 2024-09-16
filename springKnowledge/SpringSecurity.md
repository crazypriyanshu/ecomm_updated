## Spring Security

Spring security framework provides :
1. Authentication
2. Authorization
3. Protection against common attacks

#### Authentication :
Authentication is how we verify the identity of who is trying to access a particular resource.
A common way to authenticate users is by requiring the user to enter a username and password. 
Once authentication is performed we know the identity and can perform authorization.

#### Authorization:
Authorization is determining who is allowed to access a particular resource.
Spring security provides authorization based upon the request for both Servlet and WebFlux environments

1. Modelling authorization at request level : 
    We can activate it in our application by annotating any `@Configuration` class with `@EnableMethodSecurity`.
   Then, we can immediately be able to annotate any Spring-managed class or method with 
    `@PreAuthorize`, `@PostAuthorize`, `@PreFilter`, and `@PostFilter` to authorize method invocations, 
    including the input parameters and return values

##### Use cases of method security :
1. Comparing request level and method level authorization
2. Providing fallback values when authorization is denied
3. Filtering methods with `@PreFilter` and `@PostFilter`
4. Authorizing methods 
5. Coordinating with `@Transactional` and other `AOP based annotations`
6. Integrating with method security
