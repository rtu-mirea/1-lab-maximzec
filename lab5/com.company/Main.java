package com.company;

import GUI.*;
import Models.EffectiveProductionSystem;

import javax.swing.*;

public class Main {
    private static EnterWindow enterWindow;

    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        EffectiveProductionSystem effectiveProductionSystem = new EffectiveProductionSystem();
        effectiveProductionSystem.main();
    }

}
