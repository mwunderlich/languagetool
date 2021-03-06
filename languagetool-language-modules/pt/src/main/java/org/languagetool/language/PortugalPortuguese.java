/* LanguageTool, a natural language style checker 
 * Copyright (C) 2012 Daniel Naber (http://www.danielnaber.de)
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301
 * USA
 */
package org.languagetool.language;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import org.languagetool.rules.*;
import org.languagetool.rules.pt.PostReformPortugueseCompoundRule;
import org.languagetool.rules.pt.PortugalPortugueseReplaceRule;
import org.languagetool.rules.pt.PortugueseAgreementReplaceRule;

public class PortugalPortuguese extends Portuguese {

  @Override
  public String getName() {
    return "Portuguese (Portugal)";
  }

  @Override
  public String[] getCountries() {
    return new String[]{"PT"};
  }

  @Override
  public List<Rule> getRelevantRules(ResourceBundle messages) throws IOException {
    return Arrays.asList(
            new PostReformPortugueseCompoundRule(messages),
            new PortugalPortugueseReplaceRule(messages),
            new PortugueseAgreementReplaceRule(messages)
    );
  }

  @Override
  public int getPriorityForId(String id) {
    switch (id) {
      case "PORTUGUESE_OLD_SPELLING_INTERNAL": return -9;
    }
    return 0;
  }
}
