package org.emf.example.convertor;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.uml2.uml.util.UMLUtil;
import org.eclipse.uml2.uml.util.UMLUtil.UML2EcoreConverter;
import org.eclipse.uml2.uml.util.UMLUtil.Ecore2UMLConverter;

public class ConverterProperties {
    public static Map<String, String> initAllOptionsToProcess() {
        final Map<String, String> options = new HashMap<String, String>();

        options.put(Ecore2UMLConverter.OPTION__XMI_IDENTIFIERS,
                UMLUtil.OPTION__PROCESS);

        options.put(Ecore2UMLConverter.OPTION__ANNOTATION_DETAILS,
                UMLUtil.OPTION__PROCESS);

        options.put(Ecore2UMLConverter.OPTION__BODY_ANNOTATIONS,
                UMLUtil.OPTION__PROCESS);

        options.put(Ecore2UMLConverter.OPTION__DOCUMENTATION_ANNOTATIONS,
                UMLUtil.OPTION__PROCESS);

        options.put(Ecore2UMLConverter.OPTION__ECORE_TAGGED_VALUES,
                UMLUtil.OPTION__PROCESS);

        options.put(Ecore2UMLConverter.OPTION__OPPOSITE_ROLE_NAMES,
                UMLUtil.OPTION__PROCESS);

        options.put(Ecore2UMLConverter.OPTION__REDEFINES_ANNOTATIONS,
                UMLUtil.OPTION__PROCESS);


        options.put(Ecore2UMLConverter.OPTION__SUBSETS_ANNOTATIONS,
                UMLUtil.OPTION__PROCESS);

        options.put(Ecore2UMLConverter.OPTION__UNION_ANNOTATIONS,
                UMLUtil.OPTION__PROCESS);

        options.put(UML2EcoreConverter.OPTION__UNION_PROPERTIES,
                UMLUtil.OPTION__PROCESS);

        options.put(UML2EcoreConverter.OPTION__REDEFINING_OPERATIONS,
                UMLUtil.OPTION__PROCESS);

        options.put(UML2EcoreConverter.OPTION__SUBSETTING_PROPERTIES,
                UMLUtil.OPTION__PROCESS);

        options.put(UML2EcoreConverter.OPTION__DUPLICATE_FEATURE_INHERITANCE,
                UMLUtil.OPTION__PROCESS);

        options.put(UML2EcoreConverter.OPTION__DUPLICATE_FEATURES,
                UMLUtil.OPTION__PROCESS);

        options.put(UML2EcoreConverter.OPTION__DUPLICATE_OPERATION_INHERITANCE,
                UMLUtil.OPTION__PROCESS);

        options.put(UML2EcoreConverter.OPTION__DUPLICATE_OPERATIONS,
                UMLUtil.OPTION__PROCESS);

        options.put(UML2EcoreConverter.OPTION__CAMEL_CASE_NAMES,
                UMLUtil.OPTION__PROCESS);

        options.put(UML2EcoreConverter.OPTION__SUPER_CLASS_ORDER,
                UMLUtil.OPTION__PROCESS);

        options.put(UML2EcoreConverter.OPTION__ECORE_TAGGED_VALUES,
                UMLUtil.OPTION__PROCESS);

        options.put(UML2EcoreConverter.OPTION__REDEFINING_PROPERTIES,
                UMLUtil.OPTION__PROCESS);


        options.put(UML2EcoreConverter.OPTION__DERIVED_FEATURES,
                UMLUtil.OPTION__PROCESS);


        options.put(UML2EcoreConverter.OPTION__ANNOTATION_DETAILS,
                UMLUtil.OPTION__PROCESS);

        options.put(UML2EcoreConverter.OPTION__INVARIANT_CONSTRAINTS,
                UMLUtil.OPTION__PROCESS);

        options.put(UML2EcoreConverter.OPTION__OPERATION_BODIES,
                UMLUtil.OPTION__PROCESS);

        options.put(UML2EcoreConverter.OPTION__COMMENTS,
                UMLUtil.OPTION__PROCESS);

        return options;

}

}
