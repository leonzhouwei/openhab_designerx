package org.openhab.designerx.model.items.impl;

import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.openhab.designerx.model.ModelException;
import org.openhab.designerx.model.items.ColorItem;
import org.openhab.designerx.model.items.ContactItem;
import org.openhab.designerx.model.items.DateTimeItem;
import org.openhab.designerx.model.items.DimmerItem;
import org.openhab.designerx.model.items.GroupItem;
import org.openhab.designerx.model.items.Item;
import org.openhab.designerx.model.items.ItemFactory;
import org.openhab.designerx.model.items.NumberItem;
import org.openhab.designerx.model.items.RollershutterItem;
import org.openhab.designerx.model.items.StringItem;
import org.openhab.designerx.model.items.SwitchItem;

public class ItemFactoryImplTest {
	private static final ItemFactory itemFactory = new ItemFactoryImpl();

	@Test
	public void testCreateColorItem() throws ModelException {
		final String expectedTypeName = ColorItem.TYPE_NAME;
		final String expectedName = "aColorItem";
		Item item = itemFactory.createColorItem(expectedName);
		final String actualTypeName = item.getTypeName();
		final String actualName = item.getName();
		assertThat(actualTypeName, Matchers.equalTo(expectedTypeName));
		assertThat(expectedName, Matchers.equalTo(actualName));
	}

	@Test
	public void testCreateContactItem() throws ModelException {
		final String expectedTypeName = ContactItem.TYPE_NAME;
		final String expectedName = "aContactItem";
		Item item = itemFactory.createContactItem(expectedName);
		final String actualTypeName = item.getTypeName();
		final String actualName = item.getName();
		assertThat(actualTypeName, Matchers.equalTo(expectedTypeName));
		assertThat(expectedName, Matchers.equalTo(actualName));
	}

	@Test
	public void testCreateDateTimeItem() throws ModelException {
		final String expectedTypeName = DateTimeItem.TYPE_NAME;
		final String expectedName = "aDateTimeItem";
		Item item = itemFactory.createDateTimeItem(expectedName);
		final String actualTypeName = item.getTypeName();
		final String actualName = item.getName();
		assertThat(actualTypeName, Matchers.equalTo(expectedTypeName));
		assertThat(expectedName, Matchers.equalTo(actualName));
	}

	@Test
	public void testCreateDimmerItem() throws ModelException {
		final String expectedTypeName = DimmerItem.TYPE_NAME;
		final String expectedName = "aDimmerItem";
		Item item = itemFactory.createDimmerItem(expectedName);
		final String actualTypeName = item.getTypeName();
		final String actualName = item.getName();
		assertThat(actualTypeName, Matchers.equalTo(expectedTypeName));
		assertThat(expectedName, Matchers.equalTo(actualName));
	}

	@Test
	public void testCreateGroupItem() throws ModelException {
		final String expectedTypeName = GroupItem.TYPE_NAME;
		final String expectedName = "aGroupItem";
		Item item = itemFactory.createGroupItem(expectedName);
		final String actualTypeName = item.getTypeName();
		final String actualName = item.getName();
		assertThat(actualTypeName, Matchers.equalTo(expectedTypeName));
		assertThat(expectedName, Matchers.equalTo(actualName));
	}

	@Test
	public void testCreateNumberItem() throws ModelException {
		final String expectedTypeName = NumberItem.TYPE_NAME;
		final String expectedName = "aNumberItem";
		Item item = itemFactory.createNumberItem(expectedName);
		final String actualTypeName = item.getTypeName();
		final String actualName = item.getName();
		assertThat(actualTypeName, Matchers.equalTo(expectedTypeName));
		assertThat(expectedName, Matchers.equalTo(actualName));
	}

	@Test
	public void testCreateRollershutterItem() throws ModelException {
		final String expectedTypeName = RollershutterItem.TYPE_NAME;
		final String expectedName = "aRollershutterItem";
		Item item = itemFactory.createRollershutterItem(expectedName);
		final String actualTypeName = item.getTypeName();
		final String actualName = item.getName();
		assertThat(actualTypeName, Matchers.equalTo(expectedTypeName));
		assertThat(expectedName, Matchers.equalTo(actualName));
	}

	@Test
	public void testCreateStringItem() throws ModelException {
		final String expectedTypeName = StringItem.TYPE_NAME;
		final String expectedName = "aStringItem";
		Item item = itemFactory.createStringItem(expectedName);
		final String actualTypeName = item.getTypeName();
		final String actualName = item.getName();
		assertThat(actualTypeName, Matchers.equalTo(expectedTypeName));
		assertThat(expectedName, Matchers.equalTo(actualName));
	}

	@Test
	public void testCreateSwitchItem() throws ModelException {
		final String expectedTypeName = SwitchItem.TYPE_NAME;
		final String expectedName = "aSwitchItem";
		Item item = itemFactory.createSwitchItem(expectedName);
		final String actualTypeName = item.getTypeName();
		final String actualName = item.getName();
		assertThat(actualTypeName, Matchers.equalTo(expectedTypeName));
		assertThat(expectedName, Matchers.equalTo(actualName));
	}

}
