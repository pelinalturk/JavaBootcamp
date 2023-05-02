package designPatterns.mediator;

public class MediatorDemo {
    public static void main(String[] args) {
        DispatcherMediator dispatcherMediator = new DispatcherMediator();

        User onSiteStudentA = new OnSiteStudent("On-site Student A", dispatcherMediator);
        User onSiteStudentB = new OnSiteStudent("On-site Student B", dispatcherMediator);
        User remoteStudentA = new RemoteStudent("Remote Student A", dispatcherMediator);
        User remoteStudentB = new RemoteStudent("Remote Student B", dispatcherMediator);

        dispatcherMediator.addUser(onSiteStudentA);
        dispatcherMediator.addUser(onSiteStudentB);
        dispatcherMediator.addUser(remoteStudentA);
        dispatcherMediator.addUser(remoteStudentB);

        onSiteStudentA.send("Hi remote, how is going?");
        remoteStudentA.send("Hi, great. I have lots of things to do, how about you?");
        onSiteStudentB.send("It similar");
    }
}

