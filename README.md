# unit-testing
Unit Testing POC 

Case 1: For simple method
Create a method and annotate with @test {org.junit.jupiter.api.Test}
Create a object of a class to have a reference to call the method present in the controller or any other class.
Save the response and compare with the mock response by Assertions {org.junit.jupiter.api.Assertions}.
Assertions.assertEquals(expected, actual);
This we need to write for all positive and negative scenario.


Case 2: When Calling service method to get a data.
We need to add few extra things like, we don't want to talk to database so we need to stub the data to do the unit testing.
We can implement the service class or some other class to set the data. Once we set the data we can call the controller method by class 
reference then later compare these.
Here we can create a multiple stubs but this will lead to more effort to maintain, So this is not the right approch.
Approach 1:
To resolve this issue we have mocking concept introduce.
We can use mock annotation {static org.mockito.Mockito.mock} to mock the data class 
DataService dataServiceMock = mock(DataService.class);
and then pass the mock data reference to call for the data method 
inside when {static org.mockito.Mockito.when} like below.
when(dataServiceMock.retreiveAllData()).thenReturn(new int[]{1, 2, 3});

Approach 2:
With above approch we can have lot of duplicate code to avoid that we can define 
business.setDataService(dataServiceMock); inside before method with the @BeforeEach annotation and
@Mock
DataService dataServiceMock; for DataService dataServiceMock = mock(DataService.class);
@InjectMocks
BusinessImpl business; for BusinessImpl business = new BusinessImpl();
and @ExtendWith(MockitoExtension.class) above class name.


Case 3: When we have to deal with collection



What is Spy
It maintains the characterstic of the class where it is used. So when we want to use original dependency or we don't want to mock the original 
dependency but want to find out what is happening with it, We use Spy.
Usecase:->If we don't have access to any Class to get the data from it and want to see what is going underneath that specific class what method is 
getting called so we can use spy and do verification on it.

What does WebMvcTest Annottaion does?
WebMvcTest annotation helps us run any testcase written indivisually.

What are the annotation is getting used in Unit testing?

Class Level ********************************************
@ExtendWith(MockitoExtension.class) -> To write testcase for controller and service class

@DataJdbcTest -> To write testcase for repository class
@WebMvcTest(classname) -> to write a unit test case for control 

@SpringBootTest

Property Level******************************************
@InjectMocks -> to inject mock 
Ex: 
@InjectMocks
BusinessImpl business;
Explanantion->
@InjectMocks creates class objects. Use @InjectMocks to create class instances which needs to be tested in test class. Use @InjectMocks when actual 
method body needs to be executed for a given class.

@Mock  -> To mock any class
Ex:->
@Mock
DataService dataServiceMock;
Explanantion->
@Mock annotation creates mock.It is used to create and inject mocked instances of a class or interface. We do not create real objects, rather ask 
mockito to create a mock for the class.

@MockBean
DataService dataServiceMock;
Explanantion-@MockBean is a Spring Boot test annotation that is used to add mocks to ApplicationContext. A mock will replace existing bean of the same 
type defined in the context and if no existing bean then new one will be added to context.


Method level ******************************************
Test -> to mark any method as a testcase
@BeforeEach -> To set any value for object



