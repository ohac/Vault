/* This file is part of Vault.

    Vault is free software: you can redistribute it and/or modify
    it under the terms of the GNU Lesser General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Vault is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Lesser General Public License for more details.

    You should have received a copy of the GNU Lesser General Public License
    along with Vault.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.milkbowl.vault.economy.plugins;

import java.util.List;

import org.bukkit.plugin.Plugin;

import me.meta1203.plugins.sakuracoin.Sakuracoinish;

import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;

public class Economy_Sakuracoinish implements Economy {

    Plugin plugin;
    Sakuracoinish sakuraPlugin;

    public Economy_Sakuracoinish(Plugin _plugin) {
        plugin = _plugin;
        if (plugin.getServer().getPluginManager().isPluginEnabled("Sakuracoinish")) {
            sakuraPlugin = (Sakuracoinish)plugin.getServer().getPluginManager().getPlugin("Sakuracoinish");
        }
    }

    @Override
    public boolean isEnabled() {
        return sakuraPlugin != null;
    }

    @Override
    public String getName() {
        return "Sakuracoinish";
    }

    @Override
    public boolean hasBankSupport() {
        return false;
    }

    @Override
    public int fractionalDigits() {
        return 0;
    }

    @Override
    public String format(double amount) {
        return null;
    }

    @Override
    public String currencyNamePlural() {
        return Sakuracoinish.currencyName;
    }

    @Override
    public String currencyNameSingular() {
        return Sakuracoinish.currencyName;
    }

    @Override
    public boolean hasAccount(String playerName) {
        return true;
    }

    @Override
    public double getBalance(String playerName) {
        return Sakuracoinish.econ.getMoney(playerName);
    }

    @Override
    public boolean has(String playerName, double amount) {
        return (getBalance(playerName) - amount) > 0;
    }

    @Override
    public EconomyResponse withdrawPlayer(String playerName, double amount) {
        Sakuracoinish.econ.subFunds(playerName, amount);
        return new EconomyResponse(amount, getBalance(playerName), EconomyResponse.ResponseType.SUCCESS, "Worked!");
    }

    @Override
    public EconomyResponse depositPlayer(String playerName, double amount) {
        Sakuracoinish.econ.addFunds(playerName, amount);
        return new EconomyResponse(amount, getBalance(playerName), EconomyResponse.ResponseType.SUCCESS, "It worked!");
    }

    @Override
    public EconomyResponse createBank(String name, String player) {
        return new EconomyResponse(0D, 0D, EconomyResponse.ResponseType.NOT_IMPLEMENTED, "We do not use banks!");
    }

    @Override
    public EconomyResponse deleteBank(String name) {
        return new EconomyResponse(0D, 0D, EconomyResponse.ResponseType.NOT_IMPLEMENTED, "We do not use banks!");
    }

    @Override
    public EconomyResponse bankBalance(String name) {
        return new EconomyResponse(0D, 0D, EconomyResponse.ResponseType.NOT_IMPLEMENTED, "We do not use banks!");
    }

    @Override
    public EconomyResponse bankHas(String name, double amount) {
        return new EconomyResponse(0D, 0D, EconomyResponse.ResponseType.NOT_IMPLEMENTED, "We do not use banks!");
    }

    @Override
    public EconomyResponse bankWithdraw(String name, double amount) {
        return new EconomyResponse(0D, 0D, EconomyResponse.ResponseType.NOT_IMPLEMENTED, "We do not use banks!");
    }

    @Override
    public EconomyResponse bankDeposit(String name, double amount) {
        return new EconomyResponse(0D, 0D, EconomyResponse.ResponseType.NOT_IMPLEMENTED, "We do not use banks!");
    }

    @Override
    public EconomyResponse isBankOwner(String name, String playerName) {
        return null;
    }

    @Override
    public EconomyResponse isBankMember(String name, String playerName) {
        return null;
    }

    @Override
    public List<String> getBanks() {
        return null;
    }

    @Override
    public boolean createPlayerAccount(String playerName) {
        return false;
    }

    @Override
    public boolean hasAccount(String playerName, String worldName) {
        return hasAccount(playerName);
    }

    @Override
    public double getBalance(String playerName, String world) {
        return getBalance(playerName);
    }

    @Override
    public boolean has(String playerName, String worldName, double amount) {
        return has(playerName, amount);
    }

    @Override
    public EconomyResponse withdrawPlayer(String playerName, String worldName, double amount) {
        return withdrawPlayer(playerName, amount);
    }

    @Override
    public EconomyResponse depositPlayer(String playerName, String worldName, double amount) {
        return depositPlayer(playerName, amount);
    }

    @Override
    public boolean createPlayerAccount(String playerName, String worldName) {
        return createPlayerAccount(playerName);
    }
}
