package org.chothet.restapifive.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonalController {

    @GetMapping("/v1/person")
    public PersonV1 getFirstVersionOfPerson(){

        return new PersonV1("First Person");
    }

    @GetMapping("/v2/person")
    public PersonV2 getSecondVersionOfPerson(){

        return new PersonV2(new Name("Cho", "Thet"));
    }

    @GetMapping(path="/person", params="version=1")                     //http://localhost:8081/person?version=1
    public PersonV1 getFirstVersionOfPersonRequestParameter(){

        return new PersonV1("First Version with parameter");
    }

    @GetMapping(path="person", params="version=2")
    public PersonV2 getSecondVersionOfPersonRequestParameter(){

        return new PersonV2(new Name("Cho", "Thet"));
    }

    @GetMapping(path="/person", headers="X-API-VERSION=1")                     //http://localhost:8081/person,  name:X-API-VERSION, value:1
    public PersonV1 getFirstVersionOfPersonRequestHeader(){

        return new PersonV1("First Version with header");
    }

    @GetMapping(path="person", headers="X-API-VERSION=2")
    public PersonV2 getSecondVersionOfPersonRequestHeader(){

        return new PersonV2(new Name("Cho", "Thet"));
    }




}
