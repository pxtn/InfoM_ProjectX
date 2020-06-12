<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
<html> 
<body>
  <h2>InfoM - ProjectX</h2>
  <h3>Persons:</h3>
  <table border="1">
    <tr>
      <th style="text-align:left">id</th>
      <th style="text-align:left">name</th>
      <th style="text-align:left">email</th>
    </tr>
    <xsl:for-each select="DATA/ROW">
    <tr>
      <td><xsl:value-of select="id"/></td>
      <td><xsl:value-of select="email"/></td>
      <td><xsl:value-of select="name"/></td>
    </tr>
    </xsl:for-each>
  </table>
</body>
</html>
</xsl:template>
</xsl:stylesheet>

