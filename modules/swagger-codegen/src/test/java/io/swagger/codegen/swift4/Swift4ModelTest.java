package io.swagger.codegen.swift4;

import io.swagger.codegen.v3.CodegenConstants;
import io.swagger.codegen.v3.CodegenModel;
import io.swagger.codegen.v3.CodegenProperty;
import io.swagger.codegen.v3.DefaultCodegen;
import io.swagger.codegen.languages.Swift4Codegen;
import io.swagger.v3.oas.models.media.BinarySchema;
import io.swagger.v3.oas.models.media.ByteArraySchema;
import io.swagger.v3.oas.models.media.DateSchema;
import io.swagger.v3.oas.models.media.DateTimeSchema;
import io.swagger.v3.oas.models.media.Discriminator;
import io.swagger.v3.oas.models.media.IntegerSchema;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.media.StringSchema;
import io.swagger.v3.oas.models.media.UUIDSchema;
import io.swagger.v3.parser.util.SchemaTypeUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.swagger.codegen.languages.helpers.ExtensionHelper.getBooleanValue;

@SuppressWarnings("static-method")
public class Swift4ModelTest {

    @Test(description = "convert a simple java model", enabled = false)
    public void simpleModelTest() {
        final Schema schema = new Schema()
                .description("a sample model")
                .addProperties("id", new IntegerSchema().format(SchemaTypeUtil.INTEGER64_FORMAT))
                .addProperties("name", new StringSchema())
                .addProperties("createdAt", new DateTimeSchema())
                .addProperties("binary", new BinarySchema())
                .addProperties("byte", new ByteArraySchema())
                .addProperties("uuid", new UUIDSchema())
                .addProperties("dateOfBirth", new DateSchema())
                .addRequiredItem("id")
                .addRequiredItem("name")
                .discriminator(new Discriminator().mapping("test", ""));
        final DefaultCodegen codegen = new Swift4Codegen();
        final CodegenModel cm = codegen.fromModel("sample", schema);

        Assert.assertEquals(cm.name, "sample");
        Assert.assertEquals(cm.classname, "Sample");
        Assert.assertEquals(cm.description, "a sample model");
        Assert.assertEquals(cm.vars.size(), 7);
        Assert.assertEquals(cm.discriminator,"test");

        final CodegenProperty property1 = cm.vars.get(0);
        Assert.assertEquals(property1.baseName, "id");
        Assert.assertEquals(property1.datatype, "Int64");
        Assert.assertEquals(property1.name, "id");
        Assert.assertNull(property1.defaultValue);
        Assert.assertEquals(property1.baseType, "Int64");
        Assert.assertTrue(getBooleanValue(property1, CodegenConstants.HAS_MORE_EXT_NAME));
        Assert.assertTrue(property1.required);
        Assert.assertTrue(getBooleanValue(property1, CodegenConstants.IS_PRIMITIVE_TYPE_EXT_NAME));
        Assert.assertTrue(getBooleanValue(property1, CodegenConstants.IS_NOT_CONTAINER_EXT_NAME));

        final CodegenProperty property2 = cm.vars.get(1);
        Assert.assertEquals(property2.baseName, "name");
        Assert.assertEquals(property2.datatype, "String");
        Assert.assertEquals(property2.name, "name");
        Assert.assertNull(property2.defaultValue);
        Assert.assertEquals(property2.baseType, "String");
        Assert.assertTrue(getBooleanValue(property2, CodegenConstants.HAS_MORE_EXT_NAME));
        Assert.assertTrue(property2.required);
        Assert.assertTrue(getBooleanValue(property2, CodegenConstants.IS_PRIMITIVE_TYPE_EXT_NAME));
        Assert.assertTrue(getBooleanValue(property2, CodegenConstants.IS_NOT_CONTAINER_EXT_NAME));

        final CodegenProperty property3 = cm.vars.get(2);
        Assert.assertEquals(property3.baseName, "createdAt");
        Assert.assertEquals(property3.datatype, "Date");
        Assert.assertEquals(property3.name, "createdAt");
        Assert.assertNull(property3.defaultValue);
        Assert.assertEquals(property3.baseType, "Date");
        Assert.assertTrue(getBooleanValue(property3, CodegenConstants.HAS_MORE_EXT_NAME));
        Assert.assertFalse(property3.required);
        Assert.assertTrue(getBooleanValue(property3, CodegenConstants.IS_NOT_CONTAINER_EXT_NAME));

        final CodegenProperty property4 = cm.vars.get(3);
        Assert.assertEquals(property4.baseName, "binary");
        Assert.assertEquals(property4.datatype, "Data");
        Assert.assertEquals(property4.name, "binary");
        Assert.assertNull(property4.defaultValue);
        Assert.assertEquals(property4.baseType, "Data");
        Assert.assertTrue(getBooleanValue(property4, CodegenConstants.HAS_MORE_EXT_NAME));
        Assert.assertFalse(property4.required);
        Assert.assertTrue(getBooleanValue(property4, CodegenConstants.IS_NOT_CONTAINER_EXT_NAME));

        final CodegenProperty property5 = cm.vars.get(4);
        Assert.assertEquals(property5.baseName, "byte");
        Assert.assertEquals(property5.datatype, "Data");
        Assert.assertEquals(property5.name, "byte");
        Assert.assertNull(property5.defaultValue);
        Assert.assertEquals(property5.baseType, "Data");
        Assert.assertTrue(getBooleanValue(property5, CodegenConstants.HAS_MORE_EXT_NAME));
        Assert.assertFalse(property5.required);
        Assert.assertTrue(getBooleanValue(property5, CodegenConstants.IS_NOT_CONTAINER_EXT_NAME));

        final CodegenProperty property6 = cm.vars.get(5);
        Assert.assertEquals(property6.baseName, "uuid");
        Assert.assertEquals(property6.datatype, "UUID");
        Assert.assertEquals(property6.name, "uuid");
        Assert.assertNull(property6.defaultValue);
        Assert.assertEquals(property6.baseType, "UUID");
        Assert.assertTrue(getBooleanValue(property6, CodegenConstants.HAS_MORE_EXT_NAME));
        Assert.assertFalse(property6.required);
        Assert.assertTrue(getBooleanValue(property6, CodegenConstants.IS_NOT_CONTAINER_EXT_NAME));

        final CodegenProperty property7 = cm.vars.get(6);
        Assert.assertEquals(property7.baseName, "dateOfBirth");
        Assert.assertEquals(property7.datatype, "Date");
        Assert.assertEquals(property7.name, "dateOfBirth");
        Assert.assertNull(property7.defaultValue);
        Assert.assertEquals(property7.baseType, "Date");
        Assert.assertTrue(getBooleanValue(property7, CodegenConstants.HAS_MORE_EXT_NAME));
        Assert.assertFalse(property7.required);
        Assert.assertTrue(getBooleanValue(property7, CodegenConstants.IS_NOT_CONTAINER_EXT_NAME));
    }

}
