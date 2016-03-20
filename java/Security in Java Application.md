## Basic Authentication

+ [Basic Authentication in JAVA ](https://gist.github.com/neolitec/8953607)

+ [HTTP Servlet Sample Implmentation of HTTP Digest Authentication RFC 2617](https://gist.github.com/usamadar/2912088)


## Security in Java Application

+ [Authentication Type in Java EE](http://java.boot.by/wcd-guide/ch05s03.html)

+ [Basic Access Authentication](https://en.wikipedia.org/wiki/Basic_access_authentication)

+ [Base64 Conversion](https://webnet77.net/cgi-bin/helpers/base-64.pl)

+ [Short Theory](http://restcookbook.com/Basics/loggingin/)

+ [HTTP Digest Authentication](https://techannotation.wordpress.com/2012/07/02/tomcat-digestauthentication/)

+ [Wiki on Digest Auth](https://en.wikipedia.org/wiki/Digest_access_authentication)

+ [JBOSS Form Based Security](https://access.redhat.com/documentation/en-US/JBoss_Enterprise_Application_Platform/5/html/Security_Guide/Enabling_FORM_Authentication.html)

+ [How to configure Tomcat to support SSL or https](http://www.mkyong.com/tomcat/how-to-configure-tomcat-to-support-ssl-or-https/)

+ [Java Authentication and Authorization Service](https://en.wikipedia.org/wiki/Java_Authentication_and_Authorization_Service)

+ [Securing Java EE 6 Web Applications on Glassfish using JAAS](https://www.nabisoft.com/tutorials/glassfish/securing-java-ee-6-web-applications-on-glassfish-using-jaas)

+ [5 minutes with – Spring Authentication and Authorization Service (JAAS)](https://techannotation.wordpress.com/2012/12/05/5-minutes-with-spring-authentication-and-authorization-service-jaa/)

+ [JASPIC By Arjan Tijms](https://jaspic.zeef.com/arjan.tijms)

+ [Awesome Book](https://jaasbook.wordpress.com/)

+ [“Please Log In”: Authentication and Authorization in Java SE and Java EE](https://www.youtube.com/watch?v=pBDqIavwMYw)

## IBM Websphere

+ [Basic Authentication in Websphere Liberty Profile:](https://gist.github.com/dtripathy10/02aa42fdeab4bac65c1c)


## Apache Tomcat

+ [Jersey+Tomcat+BASIC](http://examples.javacodegeeks.com/core-java/jax-rs-security-example/)

## Spring Security

+ [Remastered Webinar: Spring Security Fundamentals](https://www.youtube.com/watch?v=4dISzy0syVU)

+ [Getting Started with Spring Security 3.2](https://www.youtube.com/watch?v=1zu8COg80q4)

+ [Data Modelling and Identity Management with OAuth2](https://www.youtube.com/watch?v=nMdtYnSXRpw)

+ [Security for Microservices with Spring and OAuth2](https://www.youtube.com/watch?v=MLfL1NpwUC4)

+ [simple-spring-security-webapp{Github}](https://github.com/spring-by-example/spring-by-example/tree/master/web/simple-spring-security-webapp)

+ [Get current logged in username in Spring Security](http://www.mkyong.com/spring-security/get-current-logged-in-username-in-spring-security/)

+ [Spring Security HTTP basic authentication example](http://www.mkyong.com/spring-security/spring-security-http-basic-authentication-example/)

## Apache Shiro

+ [Super Simple Application Security with Apache Shiro](https://www.youtube.com/watch?v=5ZepGFzYHpE)  [``  Note ``](https://gist.github.com/dtripathy10/4fff89a424edb7592a8e)


## Security in General

+ [OAuth and OpenID for Data Access and Identity in web apps](https://www.youtube.com/watch?v=U9Dfr_VIpic)

+ [OAuth for your API: The Big Picture! - Webinar](https://www.youtube.com/watch?v=M42ouAgPCQI)

+ [Password Security - From Zero to Hero](https://www.youtube.com/watch?v=XMH46pHSjAk)

+ [Build Secure User Interfaces using JWTs](https://www.youtube.com/watch?v=Lv9jun9Eqqw)

+ [Authentication OAuth 2.0](https://www.youtube.com/watch?v=khnmMv4_RCE)

+ [Google I/O 2012 - OAuth 2.0 for Identity and Data Access](https://www.youtube.com/watch?v=YLHyeSuBspI)

+ [Google I/O 2008 - OpenSocial, OpenID, and OAuth: Oh, My!](https://www.youtube.com/watch?v=6SYnlH5FXz0)

+ [Single Sign-On Best Practices](https://www.youtube.com/watch?v=49Xp_MlSTw8)

+ [Hands-on Training: Enable Single Sign-on with SAML and Salesforce Identity](https://www.youtube.com/watch?v=kIA1MZrNaAE)

+ [Introduction to the Salesforce Security Model](https://www.youtube.com/watch?v=c1ccSXlVjXk)

+ [NGINX and Single sign-on Authentication in Under 150 Lines of Code: Chris Whitten @nginxconf 2014](https://www.youtube.com/watch?v=bjk8vTtp0as)

+ [OAuth and OpenID Connect Deep Dive](https://www.youtube.com/watch?v=XGmUlyggXVo)

+ [Introducing OpenID Connect](https://www.youtube.com/watch?v=ZWf0vC_4ER4)

+ [OpenID Connect and its role in Native SSO](https://www.youtube.com/watch?v=mTZ0bcNphVg)

+ [Google I/O 2010 - OpenID-based SSO & OAuth for Google Apps](https://www.youtube.com/watch?v=0L_dEOjhADQ)

+ [Does OpenID Work for the Enterprise?](https://www.youtube.com/watch?v=ZxVJnxJ2Rvg)

+ [IDENTITY INFORMATION MANAGMENT ARCHITECTURE SUMMARY](http://www.cio.gov.bc.ca/local/cio/standards/documents/architecture/idim_arch_summary.pdf)

+ [OWASP](https://www.owasp.org/index.php/Main_Page)

+ [Information Security—Before & After Public-Key Cryptography](https://www.youtube.com/watch?v=1BJuuUxCaaY)

+ [Brad Templeton - The Future of Computer Security](https://www.youtube.com/watch?v=t8QuUEwrKm8)

+ [Data Security Essentials](https://www.youtube.com/watch?v=9WckTTqpD_M)


## Apache Shiro

+ Authentication
+ Authorization
+ Session Management
+ Cryptography
+ Web Support
+ Thread and Concurrency

#### Quick Terminology:

+ **Subject:-** Security specific user view
+ **Principal:-** Subjects identifying attributes
+ **Credential:-** Secret value that verify identity
+ **Realm:-** Security specific DAO

#### Authentication:

+ Identity verification.. ...proving a user is who he says he is

#### Shiro Features:

+ Subject based (Current user)
+ Single method call
+ rich exception hierarchy
+ remember me built in

#### Steps:
+ Collect principals and credentials
+ submit to authentication system
+ Allow, retry, or block access

#### Step-1: Collecting principals and credentials

``` java

//Example using most common scenarios:
//String username and password. Acquire in system-specific manner (HTTP request, GUI, etc)

UsernamePasswordToken token = new UsernamePasswordToken(username,password);
//remember me built-in, just do this:
token.setRememberMe(true);

```

#### Step-2: Submission

``` java

Subject currentUser = SecurityUtils.getSubject();
currentUser.login(token); //throws awesome exception, configurable

Note:  SecurityUtils.getSubject(); is just anonymous; after login it points something.
```

#### Remember Me support:
``` java

subject.isRembered()
subject.isuthenticate()
remembered != authenticated
```

#### Step-3: Grant access or handle failure:
``` java

currentUser.login(token); //throws awesome exception, configurable catch according to application need.
```
#### Authorisation Defined:

Process of determining Access Control "who can do what"

##### Elements of Authorisation
+ Permissions
+ Roles
+ Users

##### Permission:
+ The what of an application
+ most atomic security element
+ describes resource types and the behaviours
+ Does not define "who"

##### Roles:
+ implicit or explicit construct
+ implicit: name only
+ Explicit: a named collection of permissions
+ allows behaviour aggregation
+ enable dynamic (runtime) alternatives of user abilities

##### User:
+ The who of the applications
+ what each user can do is defined by their association with role or permission 

**Example:** users roles imply printers permission

##### Authorisation Features:
+ subject centric (current user)
+ checks based on roles or permission
+ powerful out-of-the-box wildcard permission
+ any data model - realms decide

##### How to Authorise with Shiro
+ multiple means of checking access control:
+ programmatically control
+ jdk 1.5 annotations
+ jsp/GSP taglibs (web support)

##### Programmatic Authentication: (X)
``` java
//get the current subject
Subject currentUser = SecurityUtils.getSubject();

if(currentUser.hasRole("X")) {
	//do something
} else {
	//do something else
}
```
##### better approach:(Instance level permission)
``` java
Subject currentUser = SecurityUtils.getSubject();
Permission printPermission = new PrinterPermission("laser3000n","print");
if(currentUser.isPermistted(printPermission)) {
	//do 
}else {
	//do else
}

// permission check also available in string based

String perm = "permission permission";

if(currentUser.isPermited(perm)) {

}else {

}
```

#### Annotation Authorisation:
+ Role check
+ Permission check

#### Session Management:

Managing the lifecycle of Subject specific temporal data context

#### Features:

+ heterogenous client access
+ pojo/javase based (IOC freindly)
+ event listners
+ host address retention
+ inactivity/expiration support (touch())
+ transparent web use - httpsession
+ can be used sso

#### Example:
``` java
Session session = subject.egtSession();
subject.getSession(false); //get if exist

//almost identical to httpsession
```

#### Cryptography:

Protecting information from undesired access by hiding it for converting it into nonsense.

#### Elements:
+ Ciphers
+ Hashes

#### Ciphers:

encryption or decryption based on public or private key.

+ Asymmetric Cipher: different key for encrypt or decrypt.
+ symmetric Cipher: same key for encrypt or decrypt.

#### Hashed:

A one-way, irreversible conversion of an input source (aka message Digest)

#### used for:
+ credential transformation
+ data with underlying byte array files, streams etc

#### Why?

+ Simplicity wrapper over JCE infrastructure
+ easier to understand API
+ object orient cryptography concept
+ interface driven, POJO based.

#### Web Support:

+ Simple ShiroFilter web.xml definitions.
+ Protects  all URL
+ Innovative Filtering (URL Specific chains)
+ JSP Tag support
+ Transparent HttpSession support

#### Threading and concurrency features:

+ Subject retained on multiple threads
+ automatic thread cleanup
+ transparent executor/executor-service support

#### ThreadLocal

+ currently executing subject is thread bound via a thread context
+ Executing logic in current thread is fine. What about oy=ther thread
+ runnable and callback support
+ executor service support

#### How stuff done:
``` java
//get current user
callable callable = currentuser.associatewith(mycallable);
..........
```

#### Misc:

+ Run as allows a subject to assume the identity of another
+ useful for administrative interface
+ identity retained until relinquished

#### Logout
``` java
Subject.logout();
```


## Basic Authentication in Websphere Liberty Profile:

+ web.xml
``` xml
	<!-- SECURITY ROLES -->
	<security-role>
		<role-name>students</role-name>
	</security-role>
	<!-- SECURITY CONSTRAINTS -->
	<security-constraint>
		<web-resource-collection>
			<url-pattern>/*</url-pattern>
		</web-resource-collection>
		<auth-constraint>
			<role-name>students</role-name>
		</auth-constraint>
	</security-constraint>
	<!-- AUTHENTICATION METHOD: Basic authentication -->
	<login-config>
		<auth-method>BASIC</auth-method>
	</login-config>
```

+ server.xml

``` xml
<server description="new server">

	<!-- Enable features -->
	<featureManager>
		<feature>javaee-7.0</feature>
		<feature>localConnector-1.0</feature>
		<feature>appSecurity-2.0</feature>
	</featureManager>

	<!-- This template enables security. To get the full use of all the capabilities, 
		a keystore and user registry are required. -->

	<!-- For the keystore, default keys are generated and stored in a keystore. 
		To provide the keystore password, generate an encoded password using bin/securityUtility 
		encode and add it below in the password attribute of the keyStore element. 
		Then uncomment the keyStore element. -->
	<keyStore id="defaultKeyStore" password="Anjana1!" updateTrigger="disabled">
	</keyStore>

	<!--For a user registry configuration, configure your user registry. For 
		example, configure a basic user registry using the basicRegistry element. 
		Specify your own user name below in the name attribute of the user element. 
		For the password, generate an encoded password using bin/securityUtility 
		encode and add it in the password attribute of the user element. Then uncomment 
		the user element. -->
	<basicRegistry id="basic" realm="BasicRealm">
		<user name="mlee" password="p@ssw0rd"/>
		<user name="rkumar" password="pa$$w0rd"/>
		<user name="gjones" password="{xor}Lz4sLCgwLTs="/>
		<group name="students">
			<member name="mlee"/>
			<member id="debabrata" name="debabrata"/>
			<member name="rkumar"/>
		</group>
		<user id="debabrata" name="debabrata" password="{hash}ATAAAAAI+Y//qzRoJNZAAAAAIAd1E3RO6Bb+qCaCDtlaC6WpuRCIcrrOgRGVo4wyFB5O"/>
	</basicRegistry>

	<!-- To access this server from a remote client add a host attribute to 
		the following element, e.g. host="*" -->
	<httpEndpoint httpPort="9080" id="defaultHttpEndpoint"/>


<!-- 	<applicationMonitor dropinsEnabled="false" /> -->

	<enterpriseApplication id="ws_javaeeEAR" location="ws_javaeeEAR.ear" name="ws_javaeeEAR">
		<application-bnd>
			<security-role name="students">
				<group name="students"/>
			</security-role>
<!-- 			<security-role name="admin"> -->
<!-- 				<user name="gjones" /> -->
<!-- 				<group name="administrators" /> -->
<!-- 			</security-role> -->
<!-- 			<security-role name="AllAuthenticated"> -->
<!-- 				<special-subject type="ALL_AUTHENTICATED_USERS" /> -->
<!-- 			</security-role> -->
		</application-bnd>
	</enterpriseApplication>


    <applicationMonitor updateTrigger="mbean"/>

    <webApplication id="AwesomeSecurity" location="AwesomeSecurity.war" name="AwesomeSecurity">
    <application-bnd>
			<security-role name="students">
				<group name="students"/>
			</security-role>
<!-- 			<security-role name="admin"> -->
<!-- 				<user name="gjones" /> -->
<!-- 				<group name="administrators" /> -->
<!-- 			</security-role> -->
<!-- 			<security-role name="AllAuthenticated"> -->
<!-- 				<special-subject type="ALL_AUTHENTICATED_USERS" /> -->
<!-- 			</security-role> -->
    	<security-role name="" />
    </application-bnd>
	</webApplication>
    <authentication cacheEnabled="false"/>
    <webAppSecurity httpOnlyCookies="false" singleSignonEnabled="false" useAuthenticationDataForUnprotectedResource="false"/>
    <ltpa expiration="2m"/>
    <hostAuthInfo />
    <httpSession cookiesEnabled="false"/>
</server>
```

+ Security Filter

``` java
package sample.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class SecurityFilter
 */
@WebFilter("/*")
public class SecurityFilter implements Filter {

	final String PATH = "/";
	final String DOMAIN = "";

	/**
	 * Default constructor.
	 */
	public SecurityFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
			ServletException {
		try {
			javax.security.auth.Subject caller_subject;
			com.ibm.websphere.security.cred.WSCredential caller_cred;
			caller_subject = com.ibm.websphere.security.auth.WSSubject.getCallerSubject();
			if (caller_subject != null) {
				caller_cred = caller_subject.getPublicCredentials(com.ibm.websphere.security.cred.WSCredential.class)
						.iterator().next();
				System.out.println("Principal name: " + caller_cred.getSecurityName());
				System.out.println("Access ID: " + caller_cred.getAccessId());

				System.out.println("List of Principla: " + caller_subject.getPrincipals());
				String CALLERDATA = (String) caller_cred.get("token");
				System.out.println("My data from the Caller credential is:  " + CALLERDATA);
			}
		} catch (Exception e) {
			System.out.println("Error.........");
		}

		chain.doFilter(request, response);
		Cookie[] cookies = ((HttpServletRequest) request).getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("JSESSIONID") || cookie.getName().equals("LtpaToken")
						|| cookie.getName().equals("LtpaToken2")) {
					cookie.setPath(PATH);
					cookie.setDomain(DOMAIN);
					cookie.setMaxAge(0);
					cookie.setValue("");

					((HttpServletResponse) response).addCookie(cookie);
				}
			}
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

```
+ dependency jar
``` bash
api/ibm/com.ibm.websphere.appserver.api.basic_1.2.10.jar
```
