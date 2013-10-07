/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
/*
 * This code was generated by https://code.google.com/p/google-apis-client-generator/
 * (build: 2013-09-16 16:01:30 UTC)
 * on 2013-10-07 at 10:34:04 UTC 
 * Modify at your own risk.
 */

package com.dat255.risk.network.testendpoint;

/**
 * Service definition for Testendpoint (v1).
 *
 * <p>
 * This is an API
 * </p>
 *
 * <p>
 * For more information about this service, see the
 * <a href="" target="_blank">API Documentation</a>
 * </p>
 *
 * <p>
 * This service uses {@link TestendpointRequestInitializer} to initialize global parameters via its
 * {@link Builder}.
 * </p>
 *
 * @since 1.3
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public class Testendpoint extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient {

  // Note: Leave this static initializer at the top of the file.
  static {
    com.google.api.client.util.Preconditions.checkState(
        com.google.api.client.googleapis.GoogleUtils.MAJOR_VERSION == 1 &&
        com.google.api.client.googleapis.GoogleUtils.MINOR_VERSION >= 15,
        "You are currently running with version %s of google-api-client. " +
        "You need at least version 1.15 of google-api-client to run version " +
        "1.16.0-rc of the testendpoint library.", com.google.api.client.googleapis.GoogleUtils.VERSION);
  }

  /**
   * The default encoded root URL of the service. This is determined when the library is generated
   * and normally should not be changed.
   *
   * @since 1.7
   */
  public static final String DEFAULT_ROOT_URL = "https://riskserverdat255.appspot.com/_ah/api/";

  /**
   * The default encoded service path of the service. This is determined when the library is
   * generated and normally should not be changed.
   *
   * @since 1.7
   */
  public static final String DEFAULT_SERVICE_PATH = "testendpoint/v1/";

  /**
   * The default encoded base URL of the service. This is determined when the library is generated
   * and normally should not be changed.
   */
  public static final String DEFAULT_BASE_URL = DEFAULT_ROOT_URL + DEFAULT_SERVICE_PATH;

  /**
   * Constructor.
   *
   * <p>
   * Use {@link Builder} if you need to specify any of the optional parameters.
   * </p>
   *
   * @param transport HTTP transport, which should normally be:
   *        <ul>
   *        <li>Google App Engine:
   *        {@code com.google.api.client.extensions.appengine.http.UrlFetchTransport}</li>
   *        <li>Android: {@code newCompatibleTransport} from
   *        {@code com.google.api.client.extensions.android.http.AndroidHttp}</li>
   *        <li>Java: {@link com.google.api.client.googleapis.javanet.GoogleNetHttpTransport#newTrustedTransport()}
   *        </li>
   *        </ul>
   * @param jsonFactory JSON factory, which may be:
   *        <ul>
   *        <li>Jackson: {@code com.google.api.client.json.jackson2.JacksonFactory}</li>
   *        <li>Google GSON: {@code com.google.api.client.json.gson.GsonFactory}</li>
   *        <li>Android Honeycomb or higher:
   *        {@code com.google.api.client.extensions.android.json.AndroidJsonFactory}</li>
   *        </ul>
   * @param httpRequestInitializer HTTP request initializer or {@code null} for none
   * @since 1.7
   */
  public Testendpoint(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
      com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
    this(new Builder(transport, jsonFactory, httpRequestInitializer));
  }

  /**
   * @param builder builder
   */
  Testendpoint(Builder builder) {
    super(builder);
  }

  @Override
  protected void initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest<?> httpClientRequest) throws java.io.IOException {
    super.initialize(httpClientRequest);
  }

  /**
   * Create a request for the method "getTest".
   *
   * This request holds the parameters needed by the the testendpoint server.  After setting any
   * optional parameters, call the {@link GetTest#execute()} method to invoke the remote operation.
   *
   * @param id
   * @return the request
   */
  public GetTest getTest(java.lang.String id) throws java.io.IOException {
    GetTest result = new GetTest(id);
    initialize(result);
    return result;
  }

  public class GetTest extends TestendpointRequest<com.dat255.risk.network.testendpoint.model.Test> {

    private static final String REST_PATH = "test/{id}";

    /**
     * Create a request for the method "getTest".
     *
     * This request holds the parameters needed by the the testendpoint server.  After setting any
     * optional parameters, call the {@link GetTest#execute()} method to invoke the remote operation.
     * <p> {@link
     * GetTest#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)} must
     * be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @param id
     * @since 1.13
     */
    protected GetTest(java.lang.String id) {
      super(Testendpoint.this, "GET", REST_PATH, null, com.dat255.risk.network.testendpoint.model.Test.class);
      this.id = com.google.api.client.util.Preconditions.checkNotNull(id, "Required parameter id must be specified.");
    }

    @Override
    public com.google.api.client.http.HttpResponse executeUsingHead() throws java.io.IOException {
      return super.executeUsingHead();
    }

    @Override
    public com.google.api.client.http.HttpRequest buildHttpRequestUsingHead() throws java.io.IOException {
      return super.buildHttpRequestUsingHead();
    }

    @Override
    public GetTest setAlt(java.lang.String alt) {
      return (GetTest) super.setAlt(alt);
    }

    @Override
    public GetTest setFields(java.lang.String fields) {
      return (GetTest) super.setFields(fields);
    }

    @Override
    public GetTest setKey(java.lang.String key) {
      return (GetTest) super.setKey(key);
    }

    @Override
    public GetTest setOauthToken(java.lang.String oauthToken) {
      return (GetTest) super.setOauthToken(oauthToken);
    }

    @Override
    public GetTest setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (GetTest) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public GetTest setQuotaUser(java.lang.String quotaUser) {
      return (GetTest) super.setQuotaUser(quotaUser);
    }

    @Override
    public GetTest setUserIp(java.lang.String userIp) {
      return (GetTest) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.String id;

    /**

     */
    public java.lang.String getId() {
      return id;
    }

    public GetTest setId(java.lang.String id) {
      this.id = id;
      return this;
    }

    @Override
    public GetTest set(String parameterName, Object value) {
      return (GetTest) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "insertTest".
   *
   * This request holds the parameters needed by the the testendpoint server.  After setting any
   * optional parameters, call the {@link InsertTest#execute()} method to invoke the remote operation.
   *
   * @param content the {@link com.dat255.risk.network.testendpoint.model.Test}
   * @return the request
   */
  public InsertTest insertTest(com.dat255.risk.network.testendpoint.model.Test content) throws java.io.IOException {
    InsertTest result = new InsertTest(content);
    initialize(result);
    return result;
  }

  public class InsertTest extends TestendpointRequest<com.dat255.risk.network.testendpoint.model.Test> {

    private static final String REST_PATH = "test";

    /**
     * Create a request for the method "insertTest".
     *
     * This request holds the parameters needed by the the testendpoint server.  After setting any
     * optional parameters, call the {@link InsertTest#execute()} method to invoke the remote
     * operation. <p> {@link
     * InsertTest#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
     * must be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @param content the {@link com.dat255.risk.network.testendpoint.model.Test}
     * @since 1.13
     */
    protected InsertTest(com.dat255.risk.network.testendpoint.model.Test content) {
      super(Testendpoint.this, "POST", REST_PATH, content, com.dat255.risk.network.testendpoint.model.Test.class);
    }

    @Override
    public InsertTest setAlt(java.lang.String alt) {
      return (InsertTest) super.setAlt(alt);
    }

    @Override
    public InsertTest setFields(java.lang.String fields) {
      return (InsertTest) super.setFields(fields);
    }

    @Override
    public InsertTest setKey(java.lang.String key) {
      return (InsertTest) super.setKey(key);
    }

    @Override
    public InsertTest setOauthToken(java.lang.String oauthToken) {
      return (InsertTest) super.setOauthToken(oauthToken);
    }

    @Override
    public InsertTest setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (InsertTest) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public InsertTest setQuotaUser(java.lang.String quotaUser) {
      return (InsertTest) super.setQuotaUser(quotaUser);
    }

    @Override
    public InsertTest setUserIp(java.lang.String userIp) {
      return (InsertTest) super.setUserIp(userIp);
    }

    @Override
    public InsertTest set(String parameterName, Object value) {
      return (InsertTest) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "listTest".
   *
   * This request holds the parameters needed by the the testendpoint server.  After setting any
   * optional parameters, call the {@link ListTest#execute()} method to invoke the remote operation.
   *
   * @return the request
   */
  public ListTest listTest() throws java.io.IOException {
    ListTest result = new ListTest();
    initialize(result);
    return result;
  }

  public class ListTest extends TestendpointRequest<com.dat255.risk.network.testendpoint.model.CollectionResponseTest> {

    private static final String REST_PATH = "test";

    /**
     * Create a request for the method "listTest".
     *
     * This request holds the parameters needed by the the testendpoint server.  After setting any
     * optional parameters, call the {@link ListTest#execute()} method to invoke the remote operation.
     * <p> {@link
     * ListTest#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
     * must be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @since 1.13
     */
    protected ListTest() {
      super(Testendpoint.this, "GET", REST_PATH, null, com.dat255.risk.network.testendpoint.model.CollectionResponseTest.class);
    }

    @Override
    public com.google.api.client.http.HttpResponse executeUsingHead() throws java.io.IOException {
      return super.executeUsingHead();
    }

    @Override
    public com.google.api.client.http.HttpRequest buildHttpRequestUsingHead() throws java.io.IOException {
      return super.buildHttpRequestUsingHead();
    }

    @Override
    public ListTest setAlt(java.lang.String alt) {
      return (ListTest) super.setAlt(alt);
    }

    @Override
    public ListTest setFields(java.lang.String fields) {
      return (ListTest) super.setFields(fields);
    }

    @Override
    public ListTest setKey(java.lang.String key) {
      return (ListTest) super.setKey(key);
    }

    @Override
    public ListTest setOauthToken(java.lang.String oauthToken) {
      return (ListTest) super.setOauthToken(oauthToken);
    }

    @Override
    public ListTest setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (ListTest) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public ListTest setQuotaUser(java.lang.String quotaUser) {
      return (ListTest) super.setQuotaUser(quotaUser);
    }

    @Override
    public ListTest setUserIp(java.lang.String userIp) {
      return (ListTest) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.String cursor;

    /**

     */
    public java.lang.String getCursor() {
      return cursor;
    }

    public ListTest setCursor(java.lang.String cursor) {
      this.cursor = cursor;
      return this;
    }

    @com.google.api.client.util.Key
    private java.lang.Integer limit;

    /**

     */
    public java.lang.Integer getLimit() {
      return limit;
    }

    public ListTest setLimit(java.lang.Integer limit) {
      this.limit = limit;
      return this;
    }

    @Override
    public ListTest set(String parameterName, Object value) {
      return (ListTest) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "removeTest".
   *
   * This request holds the parameters needed by the the testendpoint server.  After setting any
   * optional parameters, call the {@link RemoveTest#execute()} method to invoke the remote operation.
   *
   * @param id
   * @return the request
   */
  public RemoveTest removeTest(java.lang.String id) throws java.io.IOException {
    RemoveTest result = new RemoveTest(id);
    initialize(result);
    return result;
  }

  public class RemoveTest extends TestendpointRequest<Void> {

    private static final String REST_PATH = "test/{id}";

    /**
     * Create a request for the method "removeTest".
     *
     * This request holds the parameters needed by the the testendpoint server.  After setting any
     * optional parameters, call the {@link RemoveTest#execute()} method to invoke the remote
     * operation. <p> {@link
     * RemoveTest#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
     * must be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @param id
     * @since 1.13
     */
    protected RemoveTest(java.lang.String id) {
      super(Testendpoint.this, "DELETE", REST_PATH, null, Void.class);
      this.id = com.google.api.client.util.Preconditions.checkNotNull(id, "Required parameter id must be specified.");
    }

    @Override
    public RemoveTest setAlt(java.lang.String alt) {
      return (RemoveTest) super.setAlt(alt);
    }

    @Override
    public RemoveTest setFields(java.lang.String fields) {
      return (RemoveTest) super.setFields(fields);
    }

    @Override
    public RemoveTest setKey(java.lang.String key) {
      return (RemoveTest) super.setKey(key);
    }

    @Override
    public RemoveTest setOauthToken(java.lang.String oauthToken) {
      return (RemoveTest) super.setOauthToken(oauthToken);
    }

    @Override
    public RemoveTest setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (RemoveTest) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public RemoveTest setQuotaUser(java.lang.String quotaUser) {
      return (RemoveTest) super.setQuotaUser(quotaUser);
    }

    @Override
    public RemoveTest setUserIp(java.lang.String userIp) {
      return (RemoveTest) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.String id;

    /**

     */
    public java.lang.String getId() {
      return id;
    }

    public RemoveTest setId(java.lang.String id) {
      this.id = id;
      return this;
    }

    @Override
    public RemoveTest set(String parameterName, Object value) {
      return (RemoveTest) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "updateTest".
   *
   * This request holds the parameters needed by the the testendpoint server.  After setting any
   * optional parameters, call the {@link UpdateTest#execute()} method to invoke the remote operation.
   *
   * @param content the {@link com.dat255.risk.network.testendpoint.model.Test}
   * @return the request
   */
  public UpdateTest updateTest(com.dat255.risk.network.testendpoint.model.Test content) throws java.io.IOException {
    UpdateTest result = new UpdateTest(content);
    initialize(result);
    return result;
  }

  public class UpdateTest extends TestendpointRequest<com.dat255.risk.network.testendpoint.model.Test> {

    private static final String REST_PATH = "test";

    /**
     * Create a request for the method "updateTest".
     *
     * This request holds the parameters needed by the the testendpoint server.  After setting any
     * optional parameters, call the {@link UpdateTest#execute()} method to invoke the remote
     * operation. <p> {@link
     * UpdateTest#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
     * must be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @param content the {@link com.dat255.risk.network.testendpoint.model.Test}
     * @since 1.13
     */
    protected UpdateTest(com.dat255.risk.network.testendpoint.model.Test content) {
      super(Testendpoint.this, "PUT", REST_PATH, content, com.dat255.risk.network.testendpoint.model.Test.class);
    }

    @Override
    public UpdateTest setAlt(java.lang.String alt) {
      return (UpdateTest) super.setAlt(alt);
    }

    @Override
    public UpdateTest setFields(java.lang.String fields) {
      return (UpdateTest) super.setFields(fields);
    }

    @Override
    public UpdateTest setKey(java.lang.String key) {
      return (UpdateTest) super.setKey(key);
    }

    @Override
    public UpdateTest setOauthToken(java.lang.String oauthToken) {
      return (UpdateTest) super.setOauthToken(oauthToken);
    }

    @Override
    public UpdateTest setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (UpdateTest) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public UpdateTest setQuotaUser(java.lang.String quotaUser) {
      return (UpdateTest) super.setQuotaUser(quotaUser);
    }

    @Override
    public UpdateTest setUserIp(java.lang.String userIp) {
      return (UpdateTest) super.setUserIp(userIp);
    }

    @Override
    public UpdateTest set(String parameterName, Object value) {
      return (UpdateTest) super.set(parameterName, value);
    }
  }

  /**
   * Builder for {@link Testendpoint}.
   *
   * <p>
   * Implementation is not thread-safe.
   * </p>
   *
   * @since 1.3.0
   */
  public static final class Builder extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder {

    /**
     * Returns an instance of a new builder.
     *
     * @param transport HTTP transport, which should normally be:
     *        <ul>
     *        <li>Google App Engine:
     *        {@code com.google.api.client.extensions.appengine.http.UrlFetchTransport}</li>
     *        <li>Android: {@code newCompatibleTransport} from
     *        {@code com.google.api.client.extensions.android.http.AndroidHttp}</li>
     *        <li>Java: {@link com.google.api.client.googleapis.javanet.GoogleNetHttpTransport#newTrustedTransport()}
     *        </li>
     *        </ul>
     * @param jsonFactory JSON factory, which may be:
     *        <ul>
     *        <li>Jackson: {@code com.google.api.client.json.jackson2.JacksonFactory}</li>
     *        <li>Google GSON: {@code com.google.api.client.json.gson.GsonFactory}</li>
     *        <li>Android Honeycomb or higher:
     *        {@code com.google.api.client.extensions.android.json.AndroidJsonFactory}</li>
     *        </ul>
     * @param httpRequestInitializer HTTP request initializer or {@code null} for none
     * @since 1.7
     */
    public Builder(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
        com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
      super(
          transport,
          jsonFactory,
          DEFAULT_ROOT_URL,
          DEFAULT_SERVICE_PATH,
          httpRequestInitializer,
          false);
    }

    /** Builds a new instance of {@link Testendpoint}. */
    @Override
    public Testendpoint build() {
      return new Testendpoint(this);
    }

    @Override
    public Builder setRootUrl(String rootUrl) {
      return (Builder) super.setRootUrl(rootUrl);
    }

    @Override
    public Builder setServicePath(String servicePath) {
      return (Builder) super.setServicePath(servicePath);
    }

    @Override
    public Builder setHttpRequestInitializer(com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
      return (Builder) super.setHttpRequestInitializer(httpRequestInitializer);
    }

    @Override
    public Builder setApplicationName(String applicationName) {
      return (Builder) super.setApplicationName(applicationName);
    }

    @Override
    public Builder setSuppressPatternChecks(boolean suppressPatternChecks) {
      return (Builder) super.setSuppressPatternChecks(suppressPatternChecks);
    }

    @Override
    public Builder setSuppressRequiredParameterChecks(boolean suppressRequiredParameterChecks) {
      return (Builder) super.setSuppressRequiredParameterChecks(suppressRequiredParameterChecks);
    }

    @Override
    public Builder setSuppressAllChecks(boolean suppressAllChecks) {
      return (Builder) super.setSuppressAllChecks(suppressAllChecks);
    }

    /**
     * Set the {@link TestendpointRequestInitializer}.
     *
     * @since 1.12
     */
    public Builder setTestendpointRequestInitializer(
        TestendpointRequestInitializer testendpointRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(testendpointRequestInitializer);
    }

    @Override
    public Builder setGoogleClientRequestInitializer(
        com.google.api.client.googleapis.services.GoogleClientRequestInitializer googleClientRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(googleClientRequestInitializer);
    }
  }
}
