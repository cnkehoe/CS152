public class Author {
    /**
     * author has 4 variables
     * given name
     * surname
     * birth year
     * death year
     */
    private String givenName;
    private String surname;
    private int birth;
    private int death;
    
    /**
     * @param givenName author's first name
     * @param surname author's last name
     * Creates a new Author with a name, but birth and death years not set
     */
    public Author (String givenName, String surname) {
        this.givenName = givenName;
        this.surname = surname;
    }
    
    /**
     * @return Author's year of birth
     */
    public int getBirthYear () {
        return birth;
    }
    
    /**
     * @return Author's year of death
     */
    public int getDeathYear () {
        return death;
    }
    
    /**
     * @param birth given birth year
     * Sets the author's year of birth, gives an error if a valid  year
     * has not been entered, or if no year is entered
     */
    public void setLifespan (int birth) {
        if (birth > -2000 && birth < 2024 && birth == 0) {
            this.birth = birth;
        }
        else {
            System.out.println("Please enter a year between -2000" +
                    " and 2024");
        }
    }
    
    
    /**
     * @param birth given birth year
     * @param death given death year
     * Sets the author's year of birth and death. An error occurs if the
     * years are not valid or if death is less than birth
     */
    public void setLifespan (int birth, int death) {
        if (birth > -2000 && birth < 2024 && birth < death && birth != 0
                && death > -2000 && death < 2024 && death != 0) {
            this.birth = birth;
            this.death = death;
        }
        else {
            System.out.println("Please enter a valid year");
        }
        
    }
    
    /**
     * Checks to see if two authors are the same
     * @param other the author that's being compared to current author
     * @return whether or not the authors are the same
     */
    
    public boolean hasSameName(Author other) {
        //if both the surname and the given name are the same,
        // they are the same author, if not, could still be the same
    if (this.toString().equals(other.toString())) {
        return true;
    }
    //if the surnames are different, they are not the same author
    else if (!this.surname.equals(other.surname)) {
        return false;
    }
    String firstInital = this.givenName.substring(0, 1);
    String firstInital2 = other.givenName.substring(0, 1);
    
    //if the first initials are the same and a given name
        // was input as the first initial, they are the same author
    if(firstInital.equals(firstInital2)) {
        return (this.givenName.equals(firstInital)) ||
                other.givenName.equals(firstInital2);
    }
    
    //if the first initials aren't the same, they are not the same author
    else {
        return false;
    }
    }
    
    public String toString() {
        return surname + ", " + givenName;
    }
    
    /**
     * Creates and returns a string based on the information given
     * @return properly formatted string
     */
    
    public String infoString() {
        String info = this.toString();
        
        if (birth != AuthorBookConstants.UNKNOWN_YEAR &&
        death != AuthorBookConstants.UNKNOWN_YEAR) {
            info += " (" + birth + "-" + death + ")";
        }
        else if (birth != AuthorBookConstants.UNKNOWN_YEAR) {
            info += " (b. " + birth + ")";
        }
        return info;
    }
    
    
}