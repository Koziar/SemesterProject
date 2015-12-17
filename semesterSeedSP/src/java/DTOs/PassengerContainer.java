package DTOs;

public class PassengerContainer {
    
    private String firstName;
        private String lastName;

        public PassengerContainer(String firstname, String lastname) {
            this.firstName = firstname;
            this.lastName = lastname;
        }

        public String getFirstname() {
            return firstName;
        }

        public void setFirstname(String firstname) {
            this.firstName = firstname;
        }

        public String getLastname() {
            return lastName;
        }

        public void setLastname(String lastname) {
            this.lastName = lastname;
        }
    
}
