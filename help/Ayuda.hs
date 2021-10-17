<?xml version='1.0' encoding='ISO-8859-1' ?>
<!DOCTYPE helpset
  PUBLIC "-//Sun Microsystems Inc.//DTD JavaHelp HelpSet Version 1.0//EN"
         "http://java.sun.com/products/javahelp/helpset_1_0.dtd">


<helpset version="1.0">
  <!-- title -->
  <title>Ayuda al usuario de Casino: Ruleta</title>

  <!-- maps -->
  <maps>
     <homeID>introduccion</homeID>
     <mapref location="Map.jhm"/>
  </maps>

  <!-- views -->
  <view>
    <name>Tabla de contenidos</name>
    <label>Tabla de contenidos</label>
    <type>javax.help.TOCView</type>
    <data>TOC.xml</data>
  </view>

  <view>
    <name>Índice</name>
    <label>Índice</label>
    <type>javax.help.IndexView</type>
    <data>Indice.xml</data>
  </view>

  <view>
    <name>Búsqueda</name>
    <label>Búsqueda</label>
    <type>javax.help.SearchView</type>
    <data engine="com.sun.java.help.search.DefaultSearchEngine">
      JavaHelpSearch
    </data>
  </view>

</helpset>