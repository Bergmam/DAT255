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
 * on 2013-10-04 at 09:10:22 UTC 
 * Modify at your own risk.
 */

package com.dat255.risk.network.testendpoint.model;

/**
 * Model definition for Test.
 *
 * <p> This is the Java data model class that specifies how to parse/serialize into the JSON that is
 * transmitted over HTTP when working with the testendpoint. For a detailed explanation see:
 * <a href="http://code.google.com/p/google-http-java-client/wiki/JSON">http://code.google.com/p/google-http-java-client/wiki/JSON</a>
 * </p>
 *
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public final class Test extends com.google.api.client.json.GenericJson {

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String id;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private Enumeration initParameterNames;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String malarn;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private ServletConfig servletConfig;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private ServletContext servletContext;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String servletInfo;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String servletName;

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getId() {
    return id;
  }

  /**
   * @param id id or {@code null} for none
   */
  public Test setId(java.lang.String id) {
    this.id = id;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public Enumeration getInitParameterNames() {
    return initParameterNames;
  }

  /**
   * @param initParameterNames initParameterNames or {@code null} for none
   */
  public Test setInitParameterNames(Enumeration initParameterNames) {
    this.initParameterNames = initParameterNames;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getMalarn() {
    return malarn;
  }

  /**
   * @param malarn malarn or {@code null} for none
   */
  public Test setMalarn(java.lang.String malarn) {
    this.malarn = malarn;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public ServletConfig getServletConfig() {
    return servletConfig;
  }

  /**
   * @param servletConfig servletConfig or {@code null} for none
   */
  public Test setServletConfig(ServletConfig servletConfig) {
    this.servletConfig = servletConfig;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public ServletContext getServletContext() {
    return servletContext;
  }

  /**
   * @param servletContext servletContext or {@code null} for none
   */
  public Test setServletContext(ServletContext servletContext) {
    this.servletContext = servletContext;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getServletInfo() {
    return servletInfo;
  }

  /**
   * @param servletInfo servletInfo or {@code null} for none
   */
  public Test setServletInfo(java.lang.String servletInfo) {
    this.servletInfo = servletInfo;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getServletName() {
    return servletName;
  }

  /**
   * @param servletName servletName or {@code null} for none
   */
  public Test setServletName(java.lang.String servletName) {
    this.servletName = servletName;
    return this;
  }

  @Override
  public Test set(String fieldName, Object value) {
    return (Test) super.set(fieldName, value);
  }

  @Override
  public Test clone() {
    return (Test) super.clone();
  }

}
