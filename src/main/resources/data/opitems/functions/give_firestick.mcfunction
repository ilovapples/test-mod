give @p opitems:fire_stick{AttributeModifiers:[{AttributeName:"generic.attack_speed",Amount:500,Name:"generic.attack_speed",UUID:[I;-123111,43379,162721,-86758]},{AttributeName:"generic.movement_speed",Amount:0.3,Name:"generic.movement_speed",UUID:[I;-123111,43479,162721,-86958]},{AttributeName:"generic.knockback_resistance",Amount:100,Name:"generic.knockback_resistance",UUID:[I;-123111,43579,162721,-87158]},{AttributeName:"generic.armor_toughness",Amount:50,Operation:2,Name:"generic.armor_toughness",UUID:[I;-123111,43679,162721,-87358]},{AttributeName:"generic.attack_damage",Amount:10,Name:"generic.attack_damage",UUID:[I;-123111,43779,162721,-87558]}],Enchantments:[{id:knockback,lvl:4}, {id:fire_aspect, lvl:5}, {id:"opitems:op_ench", lvl:15}], display:{Name:'{"text": "Fire Stick", "color": "gold", "italic": false}'}} 1
advancement revoke @p only opitems:fire_stick
recipe take @p opitems:fire_stick_recipe
clear @p opitems:placeholder_fire
