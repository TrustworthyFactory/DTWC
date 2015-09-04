/*
 *		OPTET Factory
 *
 *	Class ComponentModelImpl 1.0 3 mars 2014
 *
 *	Copyright (c) 2013 Thales Communications & Security SAS
 *	4, Avenue des Louvresses - 92230 Gennevilliers 
 *	All rights reserved
 *
 */

package com.thalesgroup.dtwc.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.protege.owl.codegeneration.WrappedIndividual;

import com.thalesgroup.dtwc.Attribute;
import com.thalesgroup.dtwc.Behaviour;
import com.thalesgroup.dtwc.Component;
import com.thalesgroup.dtwc.ComponentModel;
import com.thalesgroup.dtwc.ObjectManagement;
import com.thalesgroup.dtwc.Stakeholder;
import com.thalesgroup.dtwc.protege.MyFactory;

/**
 * @author F. Motte
 *
 */
public class ComponentModelImpl implements ComponentModel, ObjectManagement {

	private MyFactory factory;
	private Map<String, AttributeImpl> attributeMap;
	private Map<String, ComponentImpl> componentMap;	
	private com.thalesgroup.dtwc.protege.ComponentModel componentModel_p;
	

	/**
	 * @param componentModel_p2
	 * @param factory2
	 */
	public ComponentModelImpl(
			com.thalesgroup.dtwc.protege.ComponentModel componentModel_p,
			MyFactory factory) {
		// TODO Auto-generated constructor stub
		this.factory = factory;
		this.componentModel_p = componentModel_p;
		
		attributeMap = new HashMap<String, AttributeImpl>();
		componentMap = new HashMap<String, ComponentImpl>();
		
		
		
		
		// check if attribute already exist
		Collection<? extends WrappedIndividual> attribute = componentModel_p.getHasPart();
		for (Iterator iterator = attribute.iterator(); iterator.hasNext();) {
			WrappedIndividual wrappedIndividual = (WrappedIndividual) iterator
					.next();
			com.thalesgroup.dtwc.protege.Attribute attribute_p = factory.as(wrappedIndividual, com.thalesgroup.dtwc.protege.Attribute.class);
			//systemDescription_p.addHasPart(component_p);
			System.out.println(attribute_p.getOwlIndividual().toStringID());	
			attributeMap.put(attribute_p.getOwlIndividual().toStringID(), new AttributeImpl(attribute_p, factory));
		}
		
		// check if component already exist
		Collection<? extends WrappedIndividual> component = componentModel_p.getHasSubComponent();
		for (Iterator iterator = component.iterator(); iterator.hasNext();) {
			WrappedIndividual wrappedIndividual = (WrappedIndividual) iterator
					.next();
			com.thalesgroup.dtwc.protege.Component component_p = factory.as(wrappedIndividual, com.thalesgroup.dtwc.protege.Component.class);
			//systemDescription_p.addHasPart(component_p);
			System.out.println(component_p.getOwlIndividual().toStringID());	
			componentMap.put(component_p.getOwlIndividual().toStringID(), new ComponentImpl(component_p, factory));
		}
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.ComponentModel#addAttribute(com.thalesgroup.Attribute)
	 */
	@Override
	public Attribute addAttribute(String name) {
		com.thalesgroup.dtwc.protege.Attribute attribute_p = factory.createAttribute(name);
		componentModel_p.addHasPart(attribute_p);
		AttributeImpl attr = new AttributeImpl(attribute_p, factory);
		attributeMap.put(name, attr);
		return attr;
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.ComponentModel#removeAttribute(java.lang.String)
	 */
	@Override
	public void removeAttribute(String name) {
		componentModel_p.removeHasPart(attributeMap.get(name).getProtegeObject());
		attributeMap.remove(name);
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.ComponentModel#getAttributeList()
	 */
	@Override
	public Collection<AttributeImpl> getAttributeList() {
		return attributeMap.values();
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.ComponentModel#addComponent(com.thalesgroup.Component)
	 */
	@Override
	public Component addComponent(String name) {		
		com.thalesgroup.dtwc.protege.Component component_p = factory.createComponent(name);
		componentModel_p.addHasSubComponent(component_p);		
		ComponentImpl comp = new ComponentImpl(component_p, factory);
		componentMap.put(name, comp);
		return comp;
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.ComponentModel#removeComponent(java.lang.String)
	 */
	@Override
	public void removeComponent(String name) {
		componentModel_p.removeHasSubComponent(componentMap.get(name).getProtegeObject());
		componentMap.remove(name);
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.ComponentModel#getComponentList()
	 */
	@Override
	public Collection<ComponentImpl> getComponentList() {
		return componentMap.values();
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.ObjectManagement#getProtegeObject()
	 */
	@Override
	public WrappedIndividual getProtegeObject() {
		// TODO Auto-generated method stub
		return componentModel_p;
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.ObjectManagement#clear()
	 */
	@Override
	public void clear() {
		Set<String> keys = attributeMap.keySet();
		for (Iterator iterator = keys.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			componentModel_p.removeHasPart(attributeMap.get(string).getProtegeObject());
			AttributeImpl value = attributeMap.get(string);
			value.clear();
		}
		attributeMap.clear();
		Set<String> keys2 = componentMap.keySet();
		for (Iterator iterator = keys2.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			componentModel_p.removeHasSubComponent(componentMap.get(string).getProtegeObject());
			ComponentImpl value = componentMap.get(string);
		    value.clear();
		}
		componentMap.clear();
		componentModel_p.delete();
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.dtwc.ComponentModel#setId(java.lang.String)
	 */
	@Override
	public void setId(String ID) {
		if (getId()!=null){
			componentModel_p.removeID(getId());
		}
		componentModel_p.addID(ID);
	}

	/* (non-Javadoc)
	 * @see com.thalesgroup.dtwc.ComponentModel#getId()
	 */
	@Override
	public String getId() {
		if (componentModel_p.hasID()){
			return componentModel_p.getID().iterator().next();
		}else { 
			return null;
		}
	}
}
