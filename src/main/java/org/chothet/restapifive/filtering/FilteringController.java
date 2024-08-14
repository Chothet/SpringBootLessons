package org.chothet.restapifive.filtering;


import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import java.util.Arrays;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public MappingJacksonValue filtering() {
        SomeBean someBean = new SomeBean("value1", "value2", "value3");
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);  //dynamic filter
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field3");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);        //@JsonFilter("SomeBeanFilter")
        mappingJacksonValue.setFilters(filters);

        return mappingJacksonValue;
    }       //return new SomeBean("value1", "value2", "value3"); //public SomeBean

    @GetMapping("/filtering-list")
    public MappingJacksonValue filteringList() {

        List<SomeBean> list = Arrays.asList(new SomeBean("value1", "value2", "value3"),
                new SomeBean("value1", "value2", "value3"),
                new SomeBean("value1", "value2", "value3"));

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(list);  //dynamic filter
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field3");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);        //@JsonFilter("SomeBeanFilter")
        mappingJacksonValue.setFilters(filters);

        return mappingJacksonValue;
    }
}
