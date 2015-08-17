Repo Moved to :
# https://github.com/cooldatasoft/wicket-menu #



Project aims to contain several dynamic css and javascript menu types to be used in wicket applications.


List of available css/javascript Menu's

SunriseGlossDropDownMenu

ChromeDropDownMenu

SlideInMenu

MultiLevelCssMenu


Only dependency is wicket itself

Any recommendation, bug report or wish is very welcome.

For simplicity, i will keep the version number same as wicket framework itself from now on. It will be easier to find which version is compatible with which version of wicket

```

<dependency>
  <groupId>com.cooldatasoft</groupId>
  <artifactId>wicket-menu</artifactId>
  <version>6.9.0</version>
  <type>jar</type>
  <scope>compile</scope>
</dependency>


Finally add below repository to your pom.xml

<repositories>
  <repository>
    <id>wicket-menu-release</id>
    <url>http://wicket-menu.googlecode.com/svn/maven/repo</url>
  </repository>
  <repository>
    <id>wicket-menu-snapshot</id>
    <url>http://wicket-menu.googlecode.com/svn/maven/snapshot-repo</url>
  </repository>
</repositories>

```