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
 * on 2013-10-06 at 17:08:38 UTC 
 * Modify at your own risk.
 */

package com.dat255.risk.network.riskentityendpoint;

/**
 * Service definition for Riskentityendpoint (v1).
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
 * This service uses {@link RiskentityendpointRequestInitializer} to initialize global parameters via its
 * {@link Builder}.
 * </p>
 *
 * @since 1.3
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public class Riskentityendpoint extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient {

  // Note: Leave this static initializer at the top of the file.
  static {
    com.google.api.client.util.Preconditions.checkState(
        com.google.api.client.googleapis.GoogleUtils.MAJOR_VERSION == 1 &&
        com.google.api.client.googleapis.GoogleUtils.MINOR_VERSION >= 15,
        "You are currently running with version %s of google-api-client. " +
        "You need at least version 1.15 of google-api-client to run version " +
        "1.16.0-rc of the riskentityendpoint library.", com.google.api.client.googleapis.GoogleUtils.VERSION);
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
  public static final String DEFAULT_SERVICE_PATH = "riskentityendpoint/v1/";

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
  public Riskentityendpoint(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
      com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
    this(new Builder(transport, jsonFactory, httpRequestInitializer));
  }

  /**
   * @param builder builder
   */
  Riskentityendpoint(Builder builder) {
    super(builder);
  }

  @Override
  protected void initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest<?> httpClientRequest) throws java.io.IOException {
    super.initialize(httpClientRequest);
  }

  /**
   * Create a request for the method "getRiskEntity".
   *
   * This request holds the parameters needed by the the riskentityendpoint server.  After setting any
   * optional parameters, call the {@link GetRiskEntity#execute()} method to invoke the remote
   * operation.
   *
   * @param id
   * @return the request
   */
  public GetRiskEntity getRiskEntity(java.lang.String id) throws java.io.IOException {
    GetRiskEntity result = new GetRiskEntity(id);
    initialize(result);
    return result;
  }

  public class GetRiskEntity extends RiskentityendpointRequest<com.dat255.risk.network.riskentityendpoint.model.RiskEntity> {

    private static final String REST_PATH = "riskentity/{id}";

    /**
     * Create a request for the method "getRiskEntity".
     *
     * This request holds the parameters needed by the the riskentityendpoint server.  After setting
     * any optional parameters, call the {@link GetRiskEntity#execute()} method to invoke the remote
     * operation. <p> {@link GetRiskEntity#initialize(com.google.api.client.googleapis.services.Abstra
     * ctGoogleClientRequest)} must be called to initialize this instance immediately after invoking
     * the constructor. </p>
     *
     * @param id
     * @since 1.13
     */
    protected GetRiskEntity(java.lang.String id) {
      super(Riskentityendpoint.this, "GET", REST_PATH, null, com.dat255.risk.network.riskentityendpoint.model.RiskEntity.class);
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
    public GetRiskEntity setAlt(java.lang.String alt) {
      return (GetRiskEntity) super.setAlt(alt);
    }

    @Override
    public GetRiskEntity setFields(java.lang.String fields) {
      return (GetRiskEntity) super.setFields(fields);
    }

    @Override
    public GetRiskEntity setKey(java.lang.String key) {
      return (GetRiskEntity) super.setKey(key);
    }

    @Override
    public GetRiskEntity setOauthToken(java.lang.String oauthToken) {
      return (GetRiskEntity) super.setOauthToken(oauthToken);
    }

    @Override
    public GetRiskEntity setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (GetRiskEntity) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public GetRiskEntity setQuotaUser(java.lang.String quotaUser) {
      return (GetRiskEntity) super.setQuotaUser(quotaUser);
    }

    @Override
    public GetRiskEntity setUserIp(java.lang.String userIp) {
      return (GetRiskEntity) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.String id;

    /**

     */
    public java.lang.String getId() {
      return id;
    }

    public GetRiskEntity setId(java.lang.String id) {
      this.id = id;
      return this;
    }

    @Override
    public GetRiskEntity set(String parameterName, Object value) {
      return (GetRiskEntity) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "insertRiskEntity".
   *
   * This request holds the parameters needed by the the riskentityendpoint server.  After setting any
   * optional parameters, call the {@link InsertRiskEntity#execute()} method to invoke the remote
   * operation.
   *
   * @param content the {@link com.dat255.risk.network.riskentityendpoint.model.RiskEntity}
   * @return the request
   */
  public InsertRiskEntity insertRiskEntity(com.dat255.risk.network.riskentityendpoint.model.RiskEntity content) throws java.io.IOException {
    InsertRiskEntity result = new InsertRiskEntity(content);
    initialize(result);
    return result;
  }

  public class InsertRiskEntity extends RiskentityendpointRequest<com.dat255.risk.network.riskentityendpoint.model.RiskEntity> {

    private static final String REST_PATH = "riskentity";

    /**
     * Create a request for the method "insertRiskEntity".
     *
     * This request holds the parameters needed by the the riskentityendpoint server.  After setting
     * any optional parameters, call the {@link InsertRiskEntity#execute()} method to invoke the
     * remote operation. <p> {@link InsertRiskEntity#initialize(com.google.api.client.googleapis.servi
     * ces.AbstractGoogleClientRequest)} must be called to initialize this instance immediately after
     * invoking the constructor. </p>
     *
     * @param content the {@link com.dat255.risk.network.riskentityendpoint.model.RiskEntity}
     * @since 1.13
     */
    protected InsertRiskEntity(com.dat255.risk.network.riskentityendpoint.model.RiskEntity content) {
      super(Riskentityendpoint.this, "POST", REST_PATH, content, com.dat255.risk.network.riskentityendpoint.model.RiskEntity.class);
    }

    @Override
    public InsertRiskEntity setAlt(java.lang.String alt) {
      return (InsertRiskEntity) super.setAlt(alt);
    }

    @Override
    public InsertRiskEntity setFields(java.lang.String fields) {
      return (InsertRiskEntity) super.setFields(fields);
    }

    @Override
    public InsertRiskEntity setKey(java.lang.String key) {
      return (InsertRiskEntity) super.setKey(key);
    }

    @Override
    public InsertRiskEntity setOauthToken(java.lang.String oauthToken) {
      return (InsertRiskEntity) super.setOauthToken(oauthToken);
    }

    @Override
    public InsertRiskEntity setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (InsertRiskEntity) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public InsertRiskEntity setQuotaUser(java.lang.String quotaUser) {
      return (InsertRiskEntity) super.setQuotaUser(quotaUser);
    }

    @Override
    public InsertRiskEntity setUserIp(java.lang.String userIp) {
      return (InsertRiskEntity) super.setUserIp(userIp);
    }

    @Override
    public InsertRiskEntity set(String parameterName, Object value) {
      return (InsertRiskEntity) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "listRiskEntity".
   *
   * This request holds the parameters needed by the the riskentityendpoint server.  After setting any
   * optional parameters, call the {@link ListRiskEntity#execute()} method to invoke the remote
   * operation.
   *
   * @return the request
   */
  public ListRiskEntity listRiskEntity() throws java.io.IOException {
    ListRiskEntity result = new ListRiskEntity();
    initialize(result);
    return result;
  }

  public class ListRiskEntity extends RiskentityendpointRequest<com.dat255.risk.network.riskentityendpoint.model.CollectionResponseRiskEntity> {

    private static final String REST_PATH = "riskentity";

    /**
     * Create a request for the method "listRiskEntity".
     *
     * This request holds the parameters needed by the the riskentityendpoint server.  After setting
     * any optional parameters, call the {@link ListRiskEntity#execute()} method to invoke the remote
     * operation. <p> {@link ListRiskEntity#initialize(com.google.api.client.googleapis.services.Abstr
     * actGoogleClientRequest)} must be called to initialize this instance immediately after invoking
     * the constructor. </p>
     *
     * @since 1.13
     */
    protected ListRiskEntity() {
      super(Riskentityendpoint.this, "GET", REST_PATH, null, com.dat255.risk.network.riskentityendpoint.model.CollectionResponseRiskEntity.class);
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
    public ListRiskEntity setAlt(java.lang.String alt) {
      return (ListRiskEntity) super.setAlt(alt);
    }

    @Override
    public ListRiskEntity setFields(java.lang.String fields) {
      return (ListRiskEntity) super.setFields(fields);
    }

    @Override
    public ListRiskEntity setKey(java.lang.String key) {
      return (ListRiskEntity) super.setKey(key);
    }

    @Override
    public ListRiskEntity setOauthToken(java.lang.String oauthToken) {
      return (ListRiskEntity) super.setOauthToken(oauthToken);
    }

    @Override
    public ListRiskEntity setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (ListRiskEntity) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public ListRiskEntity setQuotaUser(java.lang.String quotaUser) {
      return (ListRiskEntity) super.setQuotaUser(quotaUser);
    }

    @Override
    public ListRiskEntity setUserIp(java.lang.String userIp) {
      return (ListRiskEntity) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.String cursor;

    /**

     */
    public java.lang.String getCursor() {
      return cursor;
    }

    public ListRiskEntity setCursor(java.lang.String cursor) {
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

    public ListRiskEntity setLimit(java.lang.Integer limit) {
      this.limit = limit;
      return this;
    }

    @Override
    public ListRiskEntity set(String parameterName, Object value) {
      return (ListRiskEntity) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "removeRiskEntity".
   *
   * This request holds the parameters needed by the the riskentityendpoint server.  After setting any
   * optional parameters, call the {@link RemoveRiskEntity#execute()} method to invoke the remote
   * operation.
   *
   * @param id
   * @return the request
   */
  public RemoveRiskEntity removeRiskEntity(java.lang.String id) throws java.io.IOException {
    RemoveRiskEntity result = new RemoveRiskEntity(id);
    initialize(result);
    return result;
  }

  public class RemoveRiskEntity extends RiskentityendpointRequest<Void> {

    private static final String REST_PATH = "riskentity/{id}";

    /**
     * Create a request for the method "removeRiskEntity".
     *
     * This request holds the parameters needed by the the riskentityendpoint server.  After setting
     * any optional parameters, call the {@link RemoveRiskEntity#execute()} method to invoke the
     * remote operation. <p> {@link RemoveRiskEntity#initialize(com.google.api.client.googleapis.servi
     * ces.AbstractGoogleClientRequest)} must be called to initialize this instance immediately after
     * invoking the constructor. </p>
     *
     * @param id
     * @since 1.13
     */
    protected RemoveRiskEntity(java.lang.String id) {
      super(Riskentityendpoint.this, "DELETE", REST_PATH, null, Void.class);
      this.id = com.google.api.client.util.Preconditions.checkNotNull(id, "Required parameter id must be specified.");
    }

    @Override
    public RemoveRiskEntity setAlt(java.lang.String alt) {
      return (RemoveRiskEntity) super.setAlt(alt);
    }

    @Override
    public RemoveRiskEntity setFields(java.lang.String fields) {
      return (RemoveRiskEntity) super.setFields(fields);
    }

    @Override
    public RemoveRiskEntity setKey(java.lang.String key) {
      return (RemoveRiskEntity) super.setKey(key);
    }

    @Override
    public RemoveRiskEntity setOauthToken(java.lang.String oauthToken) {
      return (RemoveRiskEntity) super.setOauthToken(oauthToken);
    }

    @Override
    public RemoveRiskEntity setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (RemoveRiskEntity) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public RemoveRiskEntity setQuotaUser(java.lang.String quotaUser) {
      return (RemoveRiskEntity) super.setQuotaUser(quotaUser);
    }

    @Override
    public RemoveRiskEntity setUserIp(java.lang.String userIp) {
      return (RemoveRiskEntity) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.String id;

    /**

     */
    public java.lang.String getId() {
      return id;
    }

    public RemoveRiskEntity setId(java.lang.String id) {
      this.id = id;
      return this;
    }

    @Override
    public RemoveRiskEntity set(String parameterName, Object value) {
      return (RemoveRiskEntity) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "updateRiskEntity".
   *
   * This request holds the parameters needed by the the riskentityendpoint server.  After setting any
   * optional parameters, call the {@link UpdateRiskEntity#execute()} method to invoke the remote
   * operation.
   *
   * @param content the {@link com.dat255.risk.network.riskentityendpoint.model.RiskEntity}
   * @return the request
   */
  public UpdateRiskEntity updateRiskEntity(com.dat255.risk.network.riskentityendpoint.model.RiskEntity content) throws java.io.IOException {
    UpdateRiskEntity result = new UpdateRiskEntity(content);
    initialize(result);
    return result;
  }

  public class UpdateRiskEntity extends RiskentityendpointRequest<com.dat255.risk.network.riskentityendpoint.model.RiskEntity> {

    private static final String REST_PATH = "riskentity";

    /**
     * Create a request for the method "updateRiskEntity".
     *
     * This request holds the parameters needed by the the riskentityendpoint server.  After setting
     * any optional parameters, call the {@link UpdateRiskEntity#execute()} method to invoke the
     * remote operation. <p> {@link UpdateRiskEntity#initialize(com.google.api.client.googleapis.servi
     * ces.AbstractGoogleClientRequest)} must be called to initialize this instance immediately after
     * invoking the constructor. </p>
     *
     * @param content the {@link com.dat255.risk.network.riskentityendpoint.model.RiskEntity}
     * @since 1.13
     */
    protected UpdateRiskEntity(com.dat255.risk.network.riskentityendpoint.model.RiskEntity content) {
      super(Riskentityendpoint.this, "PUT", REST_PATH, content, com.dat255.risk.network.riskentityendpoint.model.RiskEntity.class);
    }

    @Override
    public UpdateRiskEntity setAlt(java.lang.String alt) {
      return (UpdateRiskEntity) super.setAlt(alt);
    }

    @Override
    public UpdateRiskEntity setFields(java.lang.String fields) {
      return (UpdateRiskEntity) super.setFields(fields);
    }

    @Override
    public UpdateRiskEntity setKey(java.lang.String key) {
      return (UpdateRiskEntity) super.setKey(key);
    }

    @Override
    public UpdateRiskEntity setOauthToken(java.lang.String oauthToken) {
      return (UpdateRiskEntity) super.setOauthToken(oauthToken);
    }

    @Override
    public UpdateRiskEntity setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (UpdateRiskEntity) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public UpdateRiskEntity setQuotaUser(java.lang.String quotaUser) {
      return (UpdateRiskEntity) super.setQuotaUser(quotaUser);
    }

    @Override
    public UpdateRiskEntity setUserIp(java.lang.String userIp) {
      return (UpdateRiskEntity) super.setUserIp(userIp);
    }

    @Override
    public UpdateRiskEntity set(String parameterName, Object value) {
      return (UpdateRiskEntity) super.set(parameterName, value);
    }
  }

  /**
   * Builder for {@link Riskentityendpoint}.
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

    /** Builds a new instance of {@link Riskentityendpoint}. */
    @Override
    public Riskentityendpoint build() {
      return new Riskentityendpoint(this);
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
     * Set the {@link RiskentityendpointRequestInitializer}.
     *
     * @since 1.12
     */
    public Builder setRiskentityendpointRequestInitializer(
        RiskentityendpointRequestInitializer riskentityendpointRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(riskentityendpointRequestInitializer);
    }

    @Override
    public Builder setGoogleClientRequestInitializer(
        com.google.api.client.googleapis.services.GoogleClientRequestInitializer googleClientRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(googleClientRequestInitializer);
    }
  }
}
