/*
 * JasperReports - Free Java Reporting Library.
 * Copyright (C) 2001 - 2011 Jaspersoft Corporation. All rights reserved.
 * http://www.jaspersoft.com
 *
 * Unless you have purchased a commercial license agreement from Jaspersoft,
 * the following license terms apply:
 *
 * This program is part of JasperReports.
 *
 * JasperReports is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JasperReports is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with JasperReports. If not, see <http://www.gnu.org/licenses/>.
 */
package net.sf.jasperreports.components.map;

import net.sf.jasperreports.components.map.type.MapImageTypeEnum;
import net.sf.jasperreports.components.map.type.MapTypeEnum;
import net.sf.jasperreports.engine.type.EvaluationTimeEnum;
import net.sf.jasperreports.engine.xml.JRBaseFactory;
import net.sf.jasperreports.engine.xml.JRXmlConstants;

import org.xml.sax.Attributes;


/**
 * @author sanda zaharia (shertage@users.sourceforge.net)
 * @version $Id$
 */
public class StandardMapFactory extends JRBaseFactory
{
	/**
	 *
	 */
	public Object createObject(Attributes atts)
	{
		StandardMapComponent map = new StandardMapComponent();
		
		EvaluationTimeEnum evaluationTime = EvaluationTimeEnum.getByName(atts.getValue(JRXmlConstants.ATTRIBUTE_evaluationTime));
		if (evaluationTime != null)
		{
			map.setEvaluationTime(evaluationTime);
		}

		if (map.getEvaluationTime() == EvaluationTimeEnum.GROUP)
		{
			String groupName = atts.getValue(JRXmlConstants.ATTRIBUTE_evaluationGroup);
			map.setEvaluationGroup(groupName);
		}
		
		MapTypeEnum mapType = MapTypeEnum.getByName(atts.getValue(JRXmlConstants.ATTRIBUTE_mapType));
		map.setMapType(mapType == null ? MapTypeEnum.ROADMAP : mapType);

		String mapScale = atts.getValue(JRXmlConstants.ATTRIBUTE_mapScale);
		if(mapScale != null)
		{
			map.setMapScale(Integer.valueOf(mapScale));
		}
		MapImageTypeEnum imageType = MapImageTypeEnum.getByName(atts.getValue(JRXmlConstants.ATTRIBUTE_imageType));
		if(imageType != null)
		{
			map.setImageType(imageType);
		}

		return map;
	}
	

}
