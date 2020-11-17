package com.safa.webservices.Web.Service.Filter;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class SomeBeanController {

    @GetMapping("/filters")
    public MappingJacksonValue createSomeBeanFilter(){
        SomeBean someBean = new SomeBean("value 1", "value 2", "value 3");

        MappingJacksonValue mapping = new MappingJacksonValue(someBean);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
        mapping.setFilters(filters);

        return mapping;
    }

    @GetMapping("/filters-list")
    public MappingJacksonValue createSomeBeanListFilter(){
        List<SomeBean> someBeanArrayList = Arrays.asList(
                new SomeBean("value 1", "value 2", "value 3"),
                new SomeBean("value 4", "value 5", "value 6")
        );

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field3");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
        MappingJacksonValue mapping = new MappingJacksonValue(someBeanArrayList);
        mapping.setFilters(filters);

        return mapping;

    }
}
