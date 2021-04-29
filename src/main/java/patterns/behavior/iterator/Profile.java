package patterns.behavior.iterator;

import java.util.ArrayList;
import java.util.List;

public class Profile implements IterableCollection<Profile>{
    private List<String> profileInformation = new ArrayList<>();
    private Profile nextProfile;

    @Override
    public Iterator<Profile> createIterator() {
        return new Iterator<Profile>() {

            @Override
            public Profile getNext() {
                return nextProfile;
            }

            @Override
            public boolean hasNext() {
                return nextProfile != null;
            }
        };
    }

    public Profile(List<String> profileInformation) {
        this.profileInformation = profileInformation;
    }

    public List<String> getProfileInformation() {
        return profileInformation;
    }

    public void setProfileInformation(List<String> profileInformation) {
        this.profileInformation = profileInformation;
    }

    public Profile getNextProfile() {
        return nextProfile;
    }

    public void setNextProfile(Profile nextProfile) {
        this.nextProfile = nextProfile;
    }
}
