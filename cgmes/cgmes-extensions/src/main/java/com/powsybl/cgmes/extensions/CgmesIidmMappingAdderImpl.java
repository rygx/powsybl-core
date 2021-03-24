/**
 * Copyright (c) 2020, RTE (http://www.rte-france.com)
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.powsybl.cgmes.extensions;

import com.powsybl.commons.extensions.AbstractExtensionAdder;
import com.powsybl.iidm.network.Network;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author Miora Ralambotiana <miora.ralambotiana at rte-france.com>
 */
public class CgmesIidmMappingAdderImpl extends AbstractExtensionAdder<Network, CgmesIidmMapping> implements CgmesIidmMappingAdder {

    private Set<String> topologicalNodes = new HashSet<>();

    public CgmesIidmMappingAdderImpl(Network extendable) {
        super(extendable);
    }

    @Override
    protected CgmesIidmMapping createExtension(Network extendable) {
        return new CgmesIidmMappingImpl(topologicalNodes);
    }

    @Override
    public CgmesIidmMappingAdder addTopologicalNode(String topologicalNode) {
        topologicalNodes.add(Objects.requireNonNull(topologicalNode));
        return this;
    }
}