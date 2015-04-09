/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function(c) {
    var b = function(d, e) {
        this.options = e;
        this.$elementFilestyle = [];
        this.$element = c(d)
    };
    b.prototype = {clear: function() {
            this.$element.val("");
            this.$elementFilestyle.find(":text").val("");
            this.$elementFilestyle.find(".badge").remove()
        }, destroy: function() {
            this.$element.removeAttr("style").removeData("filestyle").val("");
            this.$elementFilestyle.remove()
        }, disabled: function(d) {
            if (d === true) {
                if (!this.options.disabled) {
                    this.$element.attr("disabled", "true");
                    this.$elementFilestyle.find("label").attr("disabled", "true");
                    this.options.disabled = true
                }
            } else {
                if (d === false) {
                    if (this.options.disabled) {
                        this.$element.removeAttr("disabled");
                        this.$elementFilestyle.find("label").removeAttr("disabled");
                        this.options.disabled = false
                    }
                } else {
                    return this.options.disabled
                }
            }
        }, buttonBefore: function(d) {
            if (d === true) {
                if (!this.options.buttonBefore) {
                    this.options.buttonBefore = true;
                    if (this.options.input) {
                        this.$elementFilestyle.remove();
                        this.constructor();
                        this.pushNameFiles()
                    }
                }
            } else {
                if (d === false) {
                    if (this.options.buttonBefore) {
                        this.options.buttonBefore = false;
                        if (this.options.input) {
                            this.$elementFilestyle.remove();
                            this.constructor();
                            this.pushNameFiles()
                        }
                    }
                } else {
                    return this.options.buttonBefore
                }
            }
        }, icon: function(d) {
            if (d === true) {
                if (!this.options.icon) {
                    this.options.icon = true;
                    this.$elementFilestyle.find("label").prepend(this.htmlIcon())
                }
            } else {
                if (d === false) {
                    if (this.options.icon) {
                        this.options.icon = false;
                        this.$elementFilestyle.find(".glyphicon").remove()
                    }
                } else {
                    return this.options.icon
                }
            }
        }, input: function(e) {
            if (e === true) {
                if (!this.options.input) {
                    this.options.input = true;
                    if (this.options.buttonBefore) {
                        this.$elementFilestyle.append(this.htmlInput())
                    } else {
                        this.$elementFilestyle.prepend(this.htmlInput())
                    }
                    this.$elementFilestyle.find(".badge").remove();
                    this.pushNameFiles();
                    this.$elementFilestyle.find(".group-span-filestyle").addClass("input-group-btn")
                }
            } else {
                if (e === false) {
                    if (this.options.input) {
                        this.options.input = false;
                        this.$elementFilestyle.find(":text").remove();
                        var d = this.pushNameFiles();
                        if (d.length > 0 && this.options.badge) {
                            this.$elementFilestyle.find("label").append(' <span class="badge">' + d.length + "</span>")
                        }
                        this.$elementFilestyle.find(".group-span-filestyle").removeClass("input-group-btn")
                    }
                } else {
                    return this.options.input
                }
            }
        }, size: function(d) {
            if (d !== undefined) {
                var f = this.$elementFilestyle.find("label"), e = this.$elementFilestyle.find("input");
                f.removeClass("btn-lg btn-sm");
                e.removeClass("input-lg input-sm");
                if (d != "nr") {
                    f.addClass("btn-" + d);
                    e.addClass("input-" + d)
                }
            } else {
                return this.options.size
            }
        }, buttonText: function(d) {
            if (d !== undefined) {
                this.options.buttonText = d;
                this.$elementFilestyle.find("label span").html(this.options.buttonText)
            } else {
                return this.options.buttonText
            }
        }, buttonName: function(d) {
            if (d !== undefined) {
                this.options.buttonName = d;
                this.$elementFilestyle.find("label").attr({"class": "btn " + this.options.buttonName})
            } else {
                return this.options.buttonName
            }
        }, iconName: function(d) {
            if (d !== undefined) {
                this.$elementFilestyle.find(".glyphicon").attr({"class": ".glyphicon " + this.options.iconName})
            } else {
                return this.options.iconName
            }
        }, htmlIcon: function() {
            if (this.options.icon) {
                return'<span class="glyphicon ' + this.options.iconName + '"></span> '
            } else {
                return""
            }
        }, htmlInput: function() {
            if (this.options.input) {
                return'<input type="text" class="form-control ' + (this.options.size == "nr" ? "" : "input-" + this.options.size) + '" disabled> '
            } else {
                return""
            }
        }, pushNameFiles: function() {
            var d = "", f = [];
            if (this.$element[0].files === undefined) {
                f[0] = {name: this.$element[0] && this.$element[0].value}
            } else {
                f = this.$element[0].files
            }
            for (var e = 0; e < f.length; e++) {
                d += f[e].name.split("\\").pop() + ", "
            }
            if (d !== "") {
                this.$elementFilestyle.find(":text").val(d.replace(/\, $/g, ""))
            } else {
                this.$elementFilestyle.find(":text").val("")
            }
            return f
        }, constructor: function() {
            var h = this, f = "", g = h.$element.attr("id"), d = [], i = "", e;
            if (g === "" || !g) {
                g = "filestyle-" + c(".bootstrap-filestyle").length;
                h.$element.attr({id: g})
            }
            i = '<span class="group-span-filestyle ' + (h.options.input ? "input-group-btn" : "") + '"><label for="' + g + '" class="btn ' + h.options.buttonName + " " + (h.options.size == "nr" ? "" : "btn-" + h.options.size) + '" ' + (h.options.disabled ? 'disabled="true"' : "") + ">" + h.htmlIcon() + h.options.buttonText + "</label></span>";
            f = h.options.buttonBefore ? i + h.htmlInput() : h.htmlInput() + i;
            h.$elementFilestyle = c('<div class="bootstrap-filestyle input-group">' + f + "</div>");
            h.$elementFilestyle.find(".group-span-filestyle").attr("tabindex", "0").keypress(function(j) {
                if (j.keyCode === 13 || j.charCode === 32) {
                    h.$elementFilestyle.find("label").click();
                    return false
                }
            });
            h.$element.css({position: "absolute", clip: "rect(0px 0px 0px 0px)"}).attr("tabindex", "-1").after(h.$elementFilestyle);
            if (h.options.disabled) {
                h.$element.attr("disabled", "true")
            }
            h.$element.change(function() {
                var j = h.pushNameFiles();
                if (h.options.input == false && h.options.badge) {
                    if (h.$elementFilestyle.find(".badge").length == 0) {
                        h.$elementFilestyle.find("label").append(' <span class="badge">' + j.length + "</span>")
                    } else {
                        if (j.length == 0) {
                            h.$elementFilestyle.find(".badge").remove()
                        } else {
                            h.$elementFilestyle.find(".badge").html(j.length)
                        }
                    }
                } else {
                    h.$elementFilestyle.find(".badge").remove()
                }
            });
            if (window.navigator.userAgent.search(/firefox/i) > -1) {
                h.$elementFilestyle.find("label").click(function() {
                    h.$element.click();
                    return false
                })
            }
        }};
    var a = c.fn.filestyle;
    c.fn.filestyle = function(e, d) {
        var f = "", g = this.each(function() {
            if (c(this).attr("type") === "file") {
                var j = c(this), h = j.data("filestyle"), i = c.extend({}, c.fn.filestyle.defaults, e, typeof e === "object" && e);
                if (!h) {
                    j.data("filestyle", (h = new b(this, i)));
                    h.constructor()
                }
                if (typeof e === "string") {
                    f = h[e](d)
                }
            }
        });
        if (typeof f !== undefined) {
            return f
        } else {
            return g
        }
    };
    c.fn.filestyle.defaults = {buttonText: "Choose file", iconName: "glyphicon-folder-open", buttonName: "btn-default", size: "nr", input: true, badge: true, icon: true, buttonBefore: false, disabled: false};
    c.fn.filestyle.noConflict = function() {
        c.fn.filestyle = a;
        return this
    };
    c(function() {
        c(".filestyle").each(function() {
            var e = c(this), d = {input: e.attr("data-input") === "false" ? false : true, icon: e.attr("data-icon") === "false" ? false : true, buttonBefore: e.attr("data-buttonBefore") === "true" ? true : false, disabled: e.attr("data-disabled") === "true" ? true : false, size: e.attr("data-size"), buttonText: e.attr("data-buttonText"), buttonName: e.attr("data-buttonName"), iconName: e.attr("data-iconName"), badge: e.attr("data-badge") === "false" ? false : true};
            e.filestyle(d)
        })
    })
})(window.jQuery);
