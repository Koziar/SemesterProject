INSERT INTO url(`ID`, `GROUPNAME`, `MEMBERS`, `URL`)VALUES('1', 'Angular Airline', 'Test Airline for Sprint 1', 'http://angularairline-plaul.rhcloud.com/');
INSERT INTO url(`ID`, `GROUPNAME`, `MEMBERS`, `URL`)VALUES('2', 'ClassA-Group19', 'Ebbe, Andreas, Dennis', 'http://thebighornairline-ebski.rhcloud.com/GiantHornAirlineServer/');
INSERT INTO url(`ID`, `GROUPNAME`, `MEMBERS`, `URL`)VALUES('3', 'ClassA-Group2', 'Jonas, Sebastian, Tobias', 'http://jstairline-hardboilr.rhcloud.com/');
INSERT INTO url(`ID`, `GROUPNAME`, `MEMBERS`, `URL`)VALUES('4', 'ClassA-Group4', 'Emil, Rune, Nicolai', 'http://airline-nvbcphbusinesss.rhcloud.com/Travelr/');
INSERT INTO url(`ID`, `GROUPNAME`, `MEMBERS`, `URL`)VALUES('5', 'ClassA-Group42', 'Nikolaj, Casper, Mathias', 'http://justfly.azurewebsites.net/MomondoProjekt/');
INSERT INTO url(`ID`, `GROUPNAME`, `MEMBERS`, `URL`)VALUES('6', 'ClassA-GroupMPJ', 'Marta, Pernille, Jeanette', 'http://semesterproject-martamiszczyk.rhcloud.com/semesterProject/');
INSERT INTO url(`ID`, `GROUPNAME`, `MEMBERS`, `URL`)VALUES('7', 'ClassB-Group4', 'Florent, Daniel, Nicolai', 'http://airline-nharbo.rhcloud.com/airline/');
INSERT INTO url(`ID`, `GROUPNAME`, `MEMBERS`, `URL`)VALUES('8', 'COS-Group1', 'Athinodoros, Frederik, Rihards', 'http://bizz-favl.rhcloud.com/bizzairline/');
INSERT INTO url(`ID`, `GROUPNAME`, `MEMBERS`, `URL`)VALUES('9', 'COS-Group2', 'Andreas, Jonas', 'http://wildfly-x.cloudapp.net/airline/');
INSERT INTO url(`ID`, `GROUPNAME`, `MEMBERS`, `URL`)VALUES('10', 'COS-Group3 + Group4', 'Teo, Bo, Yoana, Aleks, Lukasz, Georgina', 'http://sargardon-001-site1.atempurl.com/');
INSERT INTO url(`ID`, `GROUPNAME`, `MEMBERS`, `URL`)VALUES('11', 'COS-Group5', 'Adam, William, Marc', 'http://frenchyairlines-zerosource.rhcloud.com/');
INSERT INTO url(`ID`, `GROUPNAME`, `MEMBERS`, `URL`)VALUES('12', 'COS-Group6', 'Alex, Bancho, Martin', 'http://infamouslines-baniproductions.rhcloud.com/');

INSERT INTO systemuser(`USERNAME`, `EMAIL`, `FIRSTNAME`, `LASTNAME`, `PASSWORD`)VALUES('admin', 'admin@sp.com', 'Admin', 'Adminowski', '1000:3b95217a7c3aadf48d0d33893d609fce8b3b22ba9b383e10:97cb8bb7daa1a6413db93fbc9b051b1be7df160a6c863e50');
INSERT INTO systemuser(`USERNAME`, `EMAIL`, `FIRSTNAME`, `LASTNAME`, `PASSWORD`)VALUES('user', 'user@sp.com', 'Bob', 'Angularowski', '1000:3b95217a7c3aadf48d0d33893d609fce8b3b22ba9b383e10:97cb8bb7daa1a6413db93fbc9b051b1be7df160a6c863e50');

INSERT INTO userrole(`ROLENAME`)VALUES('User');
INSERT INTO userrole(`ROLENAME`)VALUES('Admin');

INSERT INTO systemuser_userrole(`userName`,`roleName`)VALUES('admin', 'Admin');
INSERT INTO systemuser_userrole(`userName`,`roleName`)VALUES('user', 'User');

commit;