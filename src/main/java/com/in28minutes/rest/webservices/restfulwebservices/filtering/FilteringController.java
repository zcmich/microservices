package com.in28minutes.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public MappingJacksonValue retrieveSomeBean(){
        SomeBean someBean = new SomeBean("Value1", "value2", "value3");

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept( "field2");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);//for it to work add filterName SomeBeanFilter to SomeBean class

        MappingJacksonValue mapping = new MappingJacksonValue(someBean);
        mapping.setFilters(filters);

        return mapping;
    }

    @GetMapping("/filtering-list")
    public MappingJacksonValue retrieveListSomeBean(){
        List<SomeBean> someBeans = Arrays.asList(new SomeBean("Value1", "value2", "value3"), new SomeBean("Value12", "value22", "value32"));

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept( "field1","field2");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);//for it to work add filterName SomeBeanFilter to SomeBean class

        MappingJacksonValue mapping = new MappingJacksonValue(someBeans);
        mapping.setFilters(filters);

        return mapping;
    }

}
