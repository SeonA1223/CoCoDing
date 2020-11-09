package com.example.cocoding.Code.Block.Variables;

import com.example.cocoding.Code.Block.BlockItem;
import com.example.cocoding.Code.Block.BlockItems;
import com.example.cocoding.R;

public class Variables extends BlockItems {

    BlockItem variables_plus, variables_multiply, variables_division, variables_and, variables_not, variables_or, variables_pick;
    public Variables() {

        variables_plus = new BlockItem(R.drawable.variables_plus);
        variables_multiply = new BlockItem(R.drawable.variables_multiply);
        variables_division = new BlockItem(R.drawable.variables_division);

        variables_pick = new BlockItem(R.drawable.variables_pick);

        variables_and = new BlockItem(R.drawable.variables_and);
        variables_or = new BlockItem(R.drawable.variables_or);
        variables_not = new BlockItem(R.drawable.variables_not);

//
        CodeBlocks.add(variables_plus);
        CodeBlocks.add(variables_multiply);
        CodeBlocks.add(variables_division);

        CodeBlocks.add(variables_pick);

        CodeBlocks.add(variables_and);
        CodeBlocks.add(variables_or);
        CodeBlocks.add(variables_not);
    }


}
