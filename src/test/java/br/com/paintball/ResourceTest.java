package br.com.paintball;


public class ResourceTest {

	/*@Test
	public void testAdd() {
		
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
	    WebResource service = client.resource(getBaseURI());
	    
		UserTest userTest = new UserTest(1234l,-23.200f,23.300f);
		String json = userTest.toJSON();
	
		ClientResponse response = service.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON)
		        .post(ClientResponse.class,json);

		Assert.assertEquals(201, response.getStatus());
	}
	
	@Test
	public void testFind() {
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
	    WebResource service = client.resource(getBaseURI());
	    
		String obj = service.path("get").path("1234").get(String.class);
		Assert.assertTrue(obj.contains("1234"));
	}

	private static URI getBaseURI() {
		//return UriBuilder.fromUri("http://localhost:8080/paintball-pro/rest").build();
		return UriBuilder.fromUri("http://www.thiagoft.com.br/paintball-pro/rest").build();
	}*/
	
}
