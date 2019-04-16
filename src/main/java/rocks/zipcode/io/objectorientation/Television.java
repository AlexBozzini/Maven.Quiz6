package rocks.zipcode.io.objectorientation;

public class Television {
    private Boolean isOn;
    private TVChannel channel;

    public Television(){
        this.isOn = false;
        this.channel = TVChannel.MSN;
    }

    public Television(Boolean isOn, TVChannel channel){
        this.isOn = isOn;
        this.channel = channel;
    }

    public void turnOn() {
        this.isOn = true;
    }

    public void setChannel(Integer channel) throws IllegalStateException{
        if (isOn) {
            this.channel = TVChannel.getByOrdinal(channel);
        } else {
            throw new IllegalStateException();
        }
    }

    public TVChannel getChannel() {
        return channel;
    }
}
