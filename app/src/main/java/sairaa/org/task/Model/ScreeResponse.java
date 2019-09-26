package sairaa.org.task.Model;

import java.util.List;

public class ScreeResponse {

    List<ScreenFields> inputFields;

    public ScreeResponse(List<ScreenFields> inputFields) {
        this.inputFields = inputFields;
    }

    public ScreeResponse() {
    }

    public List<ScreenFields> getInputFields() {
        return inputFields;
    }

    public void setInputFields(List<ScreenFields> inputFields) {
        this.inputFields = inputFields;
    }
}
