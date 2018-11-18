package ru.stqa.pft.mantis.tests;
//Реализована интеграция тестов с баг-трекером MantisBT

import org.hibernate.service.spi.ServiceException;
import org.openqa.selenium.remote.BrowserType;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.mantis.appmanager.ApplicationManager;
import ru.stqa.pft.mantis.model.Issue;

import java.io.File;
import java.net.MalformedURLException;
import java.rmi.RemoteException;

public class TestBase {

  protected static final ApplicationManager app
          = new ApplicationManager(System.getProperty("browser", BrowserType.FIREFOX));

  @BeforeSuite //(alwaysRun = true)
  public void setUp() throws Exception {
    app.init();
    app.ftp().upload(new File("src/test/resources/config_inc.php"), "config_inc.php", "config_inc.php.bak");
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() throws Exception {
    app.ftp().restore("config_inc.php.bak", "config_inc.php");
    app.stop();

  }
  public boolean isIssueOpen(int issueId) throws RemoteException, ServiceException, MalformedURLException, javax.xml.rpc.ServiceException {

    Issue issue = app.soap().getIssueById(issueId);
    if ((issue.getStatus().equals("resolved")) ||
            (issue.getResolution().equals("fixed")) ||
            (issue.getStatus().equals("closed")))
    {
      return false;
    }
    return true;
  }

  public void skipIfNotFixed(int issueId) throws RemoteException, ServiceException, MalformedURLException, javax.xml.rpc.ServiceException {
    if (isIssueOpen(issueId))
    {
      throw new SkipException("Ignored because of issue " + issueId);
    }
  }
/*
  public boolean isBugifyIssueOpen(int issueId) {
    String issueStatus = app.bugify().getIssueByID(issueId);
    if ((issueStatus.equals("Resolved")) || (issueStatus.equals("Closed"))) {
      return false;
    }
    return true;
  }

  public void skipIfBugifyIssueNotFixed(int issueId) {
    if (isBugifyIssueOpen(issueId)) {
      throw new SkipException("Ignored because of issue " + issueId);
    }
  }
  */
}