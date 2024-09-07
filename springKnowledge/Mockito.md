# Mockito Library
Mockito is a powerful and widely used mocking framework in Java, especially for writing unit tests. It allows you to create mock objects for dependencies and control their behavior to focus on testing the functionality of the class being tested, 
rather than its dependencies.

#### Basic setup to use Mockito in Spring boot project
1. Add maven dependency in pom.xml


### Basic concepts of Mockito:
1. Mocks : Fake objects that you can configure to return certain data when their methods are called
2. Stubbing : We can tell mocks on what to return when their methods are called using `when-then` syntax
3. Verification : We can verify certain methods were called on the mock object during test

##### Use mockito :
1. @Mock : create a mock of a class
2. @InjectMocks : Inject the mock in defined class
3. @BeforeEach : Initialize Mockito annotations using `MockitoAnnotations.openMocks(this);`

Eg : 

    @Mock
    private ProductRepository productRepository;  // Create a mock of ProductRepository

    @InjectMocks
    private ProductService productService;  // Automatically inject the mock into ProductService

    @BeforeEach
    void setUp() {
        // Initialize Mockito annotations
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void testGetProductById_ProductFound() throws NotFoundException {
    // Arrange: Set up mock behavior
    Product mockProduct = new Product(1L, "Test Product");
    when(productRepository.findById(1L)).thenReturn(Optional.of(mockProduct));
            // Act: Call the method being tested
            Product product = productService.getProductById(1L);
            // Assert: Verify that the method behaves as expected
            assertNotNull(product);
            assertEquals("Test Product", product.getName());
        }`
1. Mocking (`@Mock`): We create a mock instance of ProductRepository using the @Mock annotation
2. Injecting Mocks (`@InjectMocks`): The ProductService is initialized with the mock ProductRepository ->  Automatically injects mocks into the object under test
3. Stubbing (when-thenReturn): We configure the mock behavior using the when-then syntax.
4. Verification: WE can use verify() to ensure that a method was called a certain number of times or with certain parameters
5. `@Captor`: Captures arguments passed to a mock method.
6. `@Spy`: Used to create a spy that wraps a real object, allowing you to override some methods with mock behavior
   Spies allow you to call real methods on an object but still mock certain methods