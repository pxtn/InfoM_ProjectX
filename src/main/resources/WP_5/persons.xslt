<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
<html> 
<body>
  <div style="text-align: center">
    <h2>InfoM - ProjectX</h2>
    <h3>Liste von Personen</h3>
  </div>
  <div style="display: flex; justify-content: center">
    <table border="1" style="border-collapse:collapse">
      <tr bgcolor="#999999">
        <th style="text-align:left">ID</th>
        <th style="text-align:left">Name</th>
        <th style="text-align:left">Email</th>
      </tr>
      <xsl:for-each select="DATA/ROW">
      <tr>
        <td style="padding: 5px"><xsl:value-of select="id"/></td>
        <td style="padding: 5px"><xsl:value-of select="name"/></td>
        <td style="padding: 5px"><xsl:value-of select="email"/></td>
      </tr>
      </xsl:for-each>
    </table>
  </div>
</body>
</html>
</xsl:template>
</xsl:stylesheet>

